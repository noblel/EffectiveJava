package chapter06.item30;

/**
 * @author Noblel
 *
 * 枚举类有个性能缺点，装载和初始化枚举时会有空间和时间的成本
 * 当需要一组固定常量的时候可以用枚举类
 *
 */
public enum PayrollDay {

    MONDAY(PayType.WEEKDAY),
    TUESDAY(PayType.WEEKDAY),
    WEDNESDAY(PayType.WEEKDAY),
    THURSDAY(PayType.WEEKDAY),
    FRIDAY(PayType.WEEKDAY),
    SATURDAY(PayType.WEEKEND),
    SUNDAY(PayType.WEEKEND);

    private final PayType payType;

    PayrollDay(PayType payType) {
        this.payType = payType;
    }

    double pay(double hoursWorked, double payRate) {
        return payType.pay(hoursWorked, payRate);
    }

    private enum PayType {
        WEEKDAY {
            @Override
            double overtimePay(double hrs, double payRate) {
                return hrs <= HOURS_PER_SHIFT ? 0 : (hrs - HOURS_PER_SHIFT)
                        * payRate / 2;
            }
        },

        WEEKEND {
            @Override
            double overtimePay(double hrs, double payRate) {
                return hrs * payRate / 2;
            }
        };

        private static final int HOURS_PER_SHIFT = 8;

        abstract double overtimePay(double hrs, double payRate);

        double pay(double hoursWorked, double payRate) {
            double basePay = hoursWorked * payRate;
            return basePay + overtimePay(hoursWorked, payRate);
        }
    }
}
