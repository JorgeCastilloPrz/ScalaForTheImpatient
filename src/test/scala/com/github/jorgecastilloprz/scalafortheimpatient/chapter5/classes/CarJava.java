package com.github.jorgecastilloprz.scalafortheimpatient.chapter5.classes;

/**
 * Car implementation but this time in java, to compare number of lines between the scala one and
 * this one.
 *
 * @author jorge
 * @since 29/05/15
 */
public class CarJava {

//    val manufacturer: String, val modelName: String, val modelYear: Int,
//    var licensePlate: String

    private final String manufacturer;
    private final String modelName;
    private final int modelYear;
    private String licensePlate;

    public CarJava(String manufacturer, String modelName, int modelYear, String licensePlate) {
        this.manufacturer = manufacturer;
        this.modelName = modelName;
        this.modelYear = modelYear;
        this.licensePlate = licensePlate;
    }

    public CarJava(String manufacturer, String modelName, int modelYear) {
        this(manufacturer, modelName, modelYear, "");
    }

    public CarJava(String manufacturer, String modelName, String licensePlate) {
        this(manufacturer, modelName, -1, licensePlate);
    }

    public CarJava(String manufacturer, String modelName) {
        this(manufacturer, modelName, -1, "");
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModelName() {
        return modelName;
    }

    public int getModelYear() {
        return modelYear;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
}
