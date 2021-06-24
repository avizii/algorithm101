package index;

import cn.hutool.core.collection.CollectionUtil;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Author : Avizii
 * @Create : 2021.06.24
 */
public class InvertedIndex {

    private static final String ANALYZER = " ";
    private static final Map<String, LinkedList<Posting>> index = new HashMap<>();
    private static final String[] documents = {
            "Mastering Elasticsearch 极 客 时 间 时",
            "Elasticsearch Server 极 限",
            "Elasticsearch Essentials 过 客"
    };

    public static void main(String[] args) {
        indexing();
        query();
    }

    /**
     * 构建倒排索引
     */
    private static void indexing() {
        for (int docId = 0; docId < documents.length; docId++) {
            String doc = documents[docId];
            String[] terms = doc.split(ANALYZER);
            for (int i = 0; i < terms.length; i++) {
                LinkedList<Posting> postings = index.get(terms[i]);
                if (postings == null) postings = new LinkedList<>();
                int startOffset = doc.indexOf(terms[i]);
                int endOffSet = terms[i].length() + startOffset;
                Posting posting = new Posting(terms[i], docId, 1, i, new int[]{startOffset, endOffSet});
                postings.add(posting);
                index.put(terms[i], postings);
            }
        }
    }

    /**
     * 根据关键字查询
     */
    private static void query() {
        String[] key = {"极", "Elasticsearch"};
        LinkedList<Posting> p1 = index.get(key[0]);
        LinkedList<Posting> p2 = index.get(key[1]);
        while (CollectionUtil.isNotEmpty(p1) && CollectionUtil.isNotEmpty(p2)) {
            final Posting pst1 = p1.peek();
            final Posting pst2 = p2.peek();
            if (pst1.docId == pst2.docId) {
                System.out.println(documents[pst1.docId]);
                p1.poll();
                p2.poll();
            } else if (pst1.docId < pst2.docId) {
                p1.poll();
            } else p2.poll();
        }
    }


    @Data
    @AllArgsConstructor
    private static class Posting {
        private String term;   // 单词
        private int docId;     // 文档id
        private float tf;      // 词频
        private int position;  // 文档中的位置
        private int[] offset;  // 偏移量
    }
}
