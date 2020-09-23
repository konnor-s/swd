public enum Numerals {
    M(1000),
    LM(900),
    D(500),
    CD(400),
    C(100),
    XL(90),
    L(50),
    XI(40),
    X(10),
    IX(9),
    V(5),
    IV(4),
    I(1);

    private final int num;
    Numerals(int num) {
        this.num = num;
    }
    public int getNum(){
        return num;
    }
}

