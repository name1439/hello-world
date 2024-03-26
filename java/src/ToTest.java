
import java.math.RoundingMode;
import java.text.NumberFormat;

public class ToTest {

    // 苹果的单价
    private final static int apple_price = 8;

    // 草莓的单价
    private final static int strawberry_price = 13;

    // 芒果的单价
    private final static int mango_price = 20;

    // 草莓的折扣
    private final static float strawberry_discount = 0.8f;

    // 第一题
    public static float getPrice(int appleCount, int strawberryCount) {
        return ToTest.getPrice(appleCount, strawberryCount, 1f);
    }

    public static float getPrice(int appleCount, int strawberryCount, float discount) {
        if (appleCount < 0 || strawberryCount < 0)
            throw new RuntimeException("重量不可为小数，请重新修改！");
        return ToTest.formatFloat(appleCount * ToTest.apple_price + strawberryCount * ToTest.strawberry_price * discount);
    }


    // 第二题
    public static float getPrice(int appleCount, int strawberryCount, int mangoCount) {
        return ToTest.getPrice(appleCount, strawberryCount, mangoCount, 1f);
    }


    public static float getPrice(int appleCount, int strawberryCount, int mangoCount, float discount) {
        if (mangoCount < 0)
            throw new RuntimeException("重量不可为小数，请重新修改！");
        return ToTest.formatFloat(mangoCount * ToTest.mango_price + ToTest.getPrice(appleCount, strawberryCount, discount));
    }

    // 第三题
    public static float getPriceThird(int appleCount, int strawberryCount, int mangoCount) {
        return ToTest.getPrice(appleCount, strawberryCount, mangoCount, ToTest.strawberry_discount);
    }


    // 第四题
    public static float getPriceFourth(int appleCount, int strawberryCount, int mangoCount) {
        float sum = ToTest.getPrice(appleCount, strawberryCount, mangoCount, ToTest.strawberry_discount);
        return ToTest.formatFloat(sum - ((int) (sum / 100)) * 10);
    }

    // 格式化float类型，保留两位小数
    public static float formatFloat(float num) {
        NumberFormat numberInstance = NumberFormat.getNumberInstance();
        // 设置最大小数点位数
        numberInstance.setMaximumFractionDigits(2);
        // 设置数据舍入类型
        numberInstance.setRoundingMode(RoundingMode.HALF_UP);
        return Float.parseFloat(numberInstance.format(num));
    }

    public static void main(String[] args) {
        System.out.println(ToTest.getPriceFourth(12, 3, 7));
    }


}
