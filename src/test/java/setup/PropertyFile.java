package setup;

public enum PropertyFile {
    NATIVE {
        public String toString() {
            return "nativetests.properties";
        }
    },

    WEB {
        public String toString() {
            return "webtests.properties";
        }
    }
}
