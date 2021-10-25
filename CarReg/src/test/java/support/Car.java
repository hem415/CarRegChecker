package support;

import com.opencsv.bean.CsvBindByPosition;

// Car Object creation
public class Car {
    @CsvBindByPosition(position = 0)
    private String registration;
    @CsvBindByPosition(position = 1)
    private String make;
    @CsvBindByPosition(position = 2)
    private String model;
    @CsvBindByPosition(position = 3)
    private String colour;
    @CsvBindByPosition(position = 4)
    private String year;

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Vehicle{" + "registration='" + registration + '\'' + ", make='" + make + '\'' + ", model='" + model
                + '\'' + ", colour='" + colour + '\'' + ", year='" + year + '\'' + '}';
    }
}
