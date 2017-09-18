package ru.hh.headhunterclient.domain.entity.search;

/**
 * Created by neox on 17.09.17.
 */
public class VacancySearch {

    private String query = "";
    private int page;
    private boolean cached;
    private boolean loadMore;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int currentPage) {
        this.page = currentPage;
    }

    public boolean isCached() {
        return cached;
    }

    public void setCached(boolean cached) {
        this.cached = cached;
    }

    public boolean isLoadMore() {
        return loadMore;
    }

    public void setLoadMore(boolean loadMore) {
        this.loadMore = loadMore;
    }
}
