package chapter03.item08;

/**
 * @author Noblel
 */
public final class CaseInsensitiveString {
    private final String s;

    public CaseInsensitiveString(String s) {
        if (s == null)
            throw new NullPointerException();
        this.s = s;
    }

//    @Override
//    public boolean equals(Object obj) {
//        if (obj instanceof CaseInsensitiveString)
//            return s.equalsIgnoreCase(((CaseInsensitiveString) obj).s);
//        if (obj instanceof String)
//            return s.equalsIgnoreCase((String) obj);
//        return false;
//    }

    /*
    正确的版本
     */
    @Override
    public boolean equals(Object obj) {
        return obj instanceof CaseInsensitiveString
                && ((CaseInsensitiveString) obj).s.equalsIgnoreCase(s);
    }

    public static void main(String[] args) {
        CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
        CaseInsensitiveString cis2 = new CaseInsensitiveString("Polish");
        String s = "polish";
        System.out.println(cis.equals(s) + "  " + s.equals(cis));
        System.out.println(cis.equals(cis2) + "  " + cis2.equals(cis));
    }
}
