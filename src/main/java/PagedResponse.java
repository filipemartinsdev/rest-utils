import java.util.List;

public class PagedResponse<T> {
    public final Long page;
    public final Long size;
    public final Boolean isLast;
    public final Long totalElements;
    public final Long totalPages;
    public final List<T> content;

    private PagedResponse() {
        this(null, null, null, null, null, null);
    }

    private PagedResponse(Long page, Long size, Boolean isLast, Long totalElements, Long totalPages, List<T> content) {
        this.page = page;
        this.size = size;
        this.isLast = isLast;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.content = content;
    }

    public static <T> Builder<T> builder(){
        return new Builder<>();
    }


    public static class Builder<T> {
        private Long page;
        private Long size;
        private Boolean isLast;
        private Long totalElements;
        private Long totalPages;
        private List<T> content;

        public Builder<T> page(long page) {
            this.page = page;
            return this;
        }

        public Builder<T> size(long size) {
            this.size = size;
            return this;
        }

        public Builder<T> isLast(boolean isLast) {
            this.isLast = isLast;
            return this;
        }

        public Builder<T> totalElements(long totalElements) {
            this.totalElements = totalElements;
            return this;
        }

        public Builder<T> totalPages(long totalPages) {
            this.totalPages = totalPages;
            return this;
        }

        public Builder<T> content(List<T> content) {
            this.content = content;
            return this;
        }

        public PagedResponse<T> build() {
            return new PagedResponse<>(page, size, isLast, totalElements, totalPages, content);
        }
    }
}
