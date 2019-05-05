package com.kodilla.patterns.singleton;

public final class SettingsFileEngine {
    private static SettingsFileEngine settingsFileEngineInstance = null;
    private String fileName = "";

    // ustawiając w konstruktorze private nie pozwalamy,
    // by ktoś mógł samodzielnie utworzyć obiekt tej klasy
    private SettingsFileEngine() {
    }

//    // statyczna metoda do utworzenia obiektu naszej klasy,
//    // sprawdzając najpierw, czy obiekt nie został już wcześniej utworzony
//    // w tej postaci nie będzie działał poprawnie w aplikacji wielowątkowej
//    public static SettingsFileEngine getInstance(){
//        if(settingsFileEngineInstance == null){
//            settingsFileEngineInstance = new SettingsFileEngine();
//        }
//        return settingsFileEngineInstance;
//    }

    // statyczna metoda do utworzenia obiektu naszej klasy,
    // sprawdzając najpierw, czy obiekt nie został już wcześniej utworzony
    // w tej postaci pozwala na równoczesny dostęp do zasobu przez równolegle wykonywane wątki programu

    public static SettingsFileEngine getInstance(){
        if(settingsFileEngineInstance == null) {
            synchronized (SettingsFileEngine.class) {
                if (settingsFileEngineInstance == null) {
                    settingsFileEngineInstance = new SettingsFileEngine();
                }
            }
        }
        return settingsFileEngineInstance;
    }

    public String getFileName() {
        return fileName;
    }

    public void open(final String fileName) {
        this.fileName = fileName;
        System.out.println("Opening the seetings file");
    }

    public void close() {
        this.fileName = "";
        System.out.println("Closing the seetings file");
    }

    public boolean loadSettings(){
        System.out.println("Loading settings from file");
        return true;
    }

    public boolean saveSettings(){
        System.out.println("Saving settings from file");
        return true;
    }
}
