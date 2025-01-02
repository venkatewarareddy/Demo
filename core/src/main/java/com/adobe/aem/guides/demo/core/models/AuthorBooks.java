package com.adobe.aem.guides.demo.core.models;
import java.util.List;
import java.util.Map;
import com.adobe.aem.guides.demo.core.helper.MultifieldHelper;
public interface AuthorBooks {

    String getAuthorName();

    List<String> getAuthorBooks();

    List<Map<String, String>> getBookDetailsWithMap();

    List<MultifieldHelper> getBookDetailsWithBean();

    List<MultifieldHelper> getBookDetailsWithNastedMultifield();
}
