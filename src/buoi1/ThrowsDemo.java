package buoi1;

public class ThrowsDemo {
    public static void main(String[] args) {
        String product = "DT, IP13,iPhone 13, iPhone 13 pro max, 30000000";
        validateProduct(product);

    }

    public static void validateProduct(String product) throws ProductException, NullPointerException {
        if (product.equals("") || product == null) {
            throw new ProductException("Tham so dau vao rong");
        } else if (product.indexOf(",") < 0) {
            System.out.println("tham so dau vao khong hop le");
        } else {
            String[] arr = product.split(",");
            if (arr.length != 5) {
                throw new ProductException("tham so dau vao khong hop le");
            } else {
                System.out.println("tham so dau vao hop le");
            }
        }
    }
}
