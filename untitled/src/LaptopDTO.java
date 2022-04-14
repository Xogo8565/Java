public class LaptopDTO {
    private int laptop_no;
    private String laptop_name;
    private int laptop_price;
    private String laptop_mfd;

    public LaptopDTO() {}
    public LaptopDTO(int laptop_no, String laptop_name, int laptop_price, String laptop_mfd) {
        super();
        this.laptop_no = laptop_no;
        this.laptop_name = laptop_name;
        this.laptop_price = laptop_price;
        this.laptop_mfd = laptop_mfd;
    }

    public int getLaptop_no() { return laptop_no; }
    public void setLaptop_no(int laptop_no) { this.laptop_no = laptop_no; }
    public String getLaptop_name() { return laptop_name; }
    public void setLaptop_name(String laptop_name) { this.laptop_name = laptop_name; }
    public int getLaptop_price() { return laptop_price; }
    public void setLaptop_price(int laptop_price) { this.laptop_price = laptop_price; }
    public String getLaptop_mfd() { return laptop_mfd; }
    public void setLaptop_mfd(String laptop_mfd) { this.laptop_mfd = laptop_mfd; }

    @Override
    public String toString() {
        return laptop_no + "\t" + laptop_name + "\t" + laptop_price + "\t" + laptop_mfd;
    }
}