package jupiterstein.com.jwtsample.models;

public enum Profile {
    ADMIN(1, "ROLE_ADMIN"),
    CLIENT(2, "ROLE_CUSTOMER");

    private final int code;
    private final String role_customer;

    Profile(int code, String role_customer) {

        this.code = code;
        this.role_customer = role_customer;
    }

    public int getCode() {
        return code;
    }

    public String getRole_customer() {
        return role_customer;
    }

    public static Profile toEnum(Integer code) {
        if(code == null){
            return null;
        }

        for(Profile p: Profile.values()) {
            if(code.equals(p.getCode())) {
                return p;
            }
        }

        throw null;
    }
}
