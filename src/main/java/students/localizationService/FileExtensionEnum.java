package students.localizationService;

public enum FileExtensionEnum {

    CSV("csv");

    private String extensionName;

    FileExtensionEnum(String extensionName) {
        this.extensionName = extensionName;
    }

    public String getExtensionName() {
        return extensionName;
    }
}