package com.jeanne.lowcode.searchservice;

import com.jeanne.lowcode.common.utils.JacksonUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.elasticsearch.ElasticsearchStatusException;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.Requests;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@SpringBootTest
class SearchServiceApplicationTests {

    private final static String INDEX_NAME = "springboot-demo";

    @Resource
    private RestHighLevelClient restHighLevelClient;


    /**
     * 创建索引 CreateIndexRequest
     */
    @Test
    void createIndex() throws Throwable {
        CreateIndexRequest request = new CreateIndexRequest(INDEX_NAME);
        restHighLevelClient.indices().create(request, RequestOptions.DEFAULT);
    }

    /**
     * 获取索引 GetIndexRequest
     */
    @Test
    void getIndex() {
        GetIndexRequest request = new GetIndexRequest(INDEX_NAME);

        GetIndexResponse response = null;
        try {
            response = restHighLevelClient.indices().get(request, RequestOptions.DEFAULT);
        } catch(ElasticsearchStatusException e){
            if (e.status()== RestStatus.NOT_FOUND) {
                log.error("No such an index",e);
            } else {
                log.error("ElasticsearchStatusException",e);
            }

        } catch (IOException e) {
            log.error("IOException",e);
        }
        log.info("mappings={} \n settings={}", JacksonUtils.writeValueAsString(response.getMappings()),
                JacksonUtils.writeValueAsString(response.getSettings()));
    }

    /**
     * 判断索引是否存在 GetIndexRequest
     */
    @Test
    void existIndex() throws Throwable {
        GetIndexRequest request = new GetIndexRequest(INDEX_NAME);
        boolean exists = restHighLevelClient.indices().exists(request, RequestOptions.DEFAULT);
        log.info("exists={}", exists);
    }

    /**
     * 删除索引 DeleteIndexRequest
     */
    @Test
    void deleteIndex() throws Throwable {
        DeleteIndexRequest request = new DeleteIndexRequest(INDEX_NAME);
        AcknowledgedResponse response = restHighLevelClient.indices().delete(request, RequestOptions.DEFAULT);
        log.info("isAcknowledged={}" + response.isAcknowledged());
    }

    /**
     * 创建文档 IndexRequest
     */
    @Test
    void createDoc() throws Throwable {
        IndexRequest request = new IndexRequest(INDEX_NAME);

        // 方式一：采用对象转Gson的方式创建文档
        Book book = new Book("Java编程思想", 100, Lists.newArrayList("Java", "经典", "入门", "语言"));
        request.id("001");
        request.timeout(TimeValue.timeValueSeconds(5));
        request.source(JacksonUtils.writeValueAsString(book), Requests.INDEX_CONTENT_TYPE);
        IndexResponse response = restHighLevelClient.index(request, RequestOptions.DEFAULT);
        log.info("response={}", response);

        // 方式二：采用逐一传参的方式创建文档
        request.id("002");
        request.timeout(TimeValue.timeValueSeconds(5));
        request.source("name", "Spring Boot编程思想", "price", 110, "tags", Lists.newArrayList("SpringBoot",
                "Spring", "新书"));
        response = restHighLevelClient.index(request, RequestOptions.DEFAULT);
        log.info("response={}", response);

        // 方式三：批量创建文档
        List<Book> books = Lists.newArrayList(new Book("a", 1, Lists.newArrayList("a1")),
                new Book("b", 2, Lists.newArrayList("b2")),
                new Book("c", 3, Lists.newArrayList("c3")),
                new Book("d", 4, Lists.newArrayList("d4")));
        BulkRequest bulkRequest = new BulkRequest(INDEX_NAME);
        AtomicInteger id = new AtomicInteger(1);
        books.stream().forEach(b -> bulkRequest.add(
                new IndexRequest(INDEX_NAME)
                        .id(String.valueOf(id.getAndIncrement())) // 指定文档id，不指定则取默认值
                        .source(JacksonUtils.writeValueAsString(b), Requests.INDEX_CONTENT_TYPE)));

        BulkResponse bulkResponse = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
        log.info("bulkInsert is success={}", !bulkResponse.hasFailures());
    }

    /**
     * 获取文档 GetRequest
     */
    @Test
    void getDoc() throws Throwable {
        GetRequest request = new GetRequest(INDEX_NAME, "001");
        boolean exists = restHighLevelClient.exists(request, RequestOptions.DEFAULT);
        log.info("exists={}", exists);

        GetResponse response = restHighLevelClient.get(request, RequestOptions.DEFAULT);
        log.info("response={} \n source={}", JacksonUtils.writeValueAsString(response), response.getSourceAsString());
    }

    /**
     * 更新文档 UpdateRequest
     */
    @Test
    void updateDoc() throws Throwable {
        // 方法一：直接修改响应属性
        UpdateRequest request = new UpdateRequest(INDEX_NAME, "001");
        request.doc("name", "Java编程思想最新版");
        UpdateResponse response = restHighLevelClient.update(request, RequestOptions.DEFAULT);
        log.info("status={}", response.status());

        // 方式二：Gson方式更新
        Book book = new Book("Spring Boot编程思想", 110, Lists.newArrayList("SpringBoot", "Spring",
                "新书")); // 这个book对象，应该从ES中获取；为了方便，此处我就直接new了
        book.setName("Spring Boot编程思想最新版");
        request = new UpdateRequest(INDEX_NAME, "002");
        request.doc(JacksonUtils.writeValueAsString(book), Requests.INDEX_CONTENT_TYPE);
        response = restHighLevelClient.update(request, RequestOptions.DEFAULT);
        log.info("status={}", response.status());
    }

    /**
     * 搜索文档 SearchRequest
     */
    @Test
    void searchDoc() throws Throwable {
        SearchRequest request = new SearchRequest(INDEX_NAME);
        SearchSourceBuilder builder = new SearchSourceBuilder();
        builder.timeout(TimeValue.timeValueSeconds(10));
        builder.query(QueryBuilders.matchQuery("name", "思想"));
        // builder.query(QueryBuilders.termQuery("name", "思想"));
        builder.from(0);
        builder.size(10);
        builder.highlighter(new HighlightBuilder().field("name").preTags("<muse>").postTags("</muse>")); // 高亮
        request.source(builder);
        SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);
        Arrays.stream(response.getHits().getHits()).forEach(System.out::println);
    }

    /**
     * 删除文档 DeleteRequest
     */
    @Test
    void deleteDoc() throws Throwable {
        DeleteRequest request = new DeleteRequest(INDEX_NAME, "001");
        DeleteResponse response = restHighLevelClient.delete(request, RequestOptions.DEFAULT);
        log.info("status={}", response.status());
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Book {

        private String name;

        private Integer price;

        private List<String> tags;
    }

}
