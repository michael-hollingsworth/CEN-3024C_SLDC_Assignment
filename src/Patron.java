public class Patron {
    public int id;
    public String name;
    public String address;
    public double fine;

    public Patron(int id, String name, String address, double fine) {
        // Error if id is not 7 digits long
        if (String.valueOf(id).length() > 7) {
            throw new IllegalArgumentException("ID cannot be longer than 7 characters");
        }

        // Error if fine is negative or greater than 250
        if (fine < 0.0) {
            throw new IllegalArgumentException("Fine must be a number between 0.0 and 250.00");
        }
        if (fine > 250.00) {
            throw new IllegalArgumentException("Fine must be a number between 0.0 and 250.00");
        }

        this.id = id;
        this.name = name;
        this.address = address;
        this.fine = fine;
    }

    // Getters
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public double getFine() {
        return fine;
    }


    // Setters
    public void setId(int id) {
        // Error if id is not 7 digits long
        if (String.valueOf(id).length() > 7) {
            throw new IllegalArgumentException("ID cannot be longer than 7 characters");
        }

        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setFine(double fine) {
        // Error if fine is negative or greater than 250
        if (fine < 0.0) {
            throw new IllegalArgumentException("Fine must be a number between [0.0] and [250.00]");
        }
        if (fine > 250.00) {
            throw new IllegalArgumentException("Fine must be a number between [0.0] and [250.00]");
        }

        this.fine = fine;
    }

    // toString() override
    @Override
    public String toString() {
        return (String.format("%07d", id) + "-" + name + "-" + address + "-" + fine);
    }

}
