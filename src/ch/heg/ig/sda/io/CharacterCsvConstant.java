package ch.heg.ig.sda.io;

public enum CharacterCsvConstant {

    // Création de constants afin de matcher le header du CSV :
    FIRSTNAME("First Name"),
    LASTNAME("Last Name"),
    GENDER("Gender"),
    JOB("Job"),
    BLOODSTATUS("Blood status");

    private int columnIndex;
    private final String columnName;

    CharacterCsvConstant(String columnName) {
        this.columnIndex = -1;
        this.columnName = columnName;
    }

    public int getColumnIndex() {
        return columnIndex;
    }

    public void setColumnIndex(int columnIndex) {
        this.columnIndex = columnIndex;
    }

    public String getColumnName() {
        return columnName;
    }

}