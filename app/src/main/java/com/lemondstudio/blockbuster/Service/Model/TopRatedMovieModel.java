package com.lemondstudio.blockbuster.Service.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TopRatedMovieModel {

        @SerializedName("page")
        @Expose
        private Integer page;
        @SerializedName("results")
        @Expose
        private List<TopRatedMovieResult> results = null;
        @SerializedName("total_pages")
        @Expose
        private Integer totalPages;
        @SerializedName("total_results")
        @Expose
        private Integer totalResults;

        public Integer getPage() {
            return page;
        }

        public void setPage(Integer page) {
            this.page = page;
        }

        public List<TopRatedMovieResult> getResults() {
            return results;
        }

        public void setResults(List<TopRatedMovieResult> results) {
            this.results = results;
        }

        public Integer getTotalPages() {
            return totalPages;
        }

        public void setTotalPages(Integer totalPages) {
            this.totalPages = totalPages;
        }

        public Integer getTotalResults() {
            return totalResults;
        }

        public void setTotalResults(Integer totalResults) {
            this.totalResults = totalResults;
        }

    }
