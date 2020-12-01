package homework4.data;


import homework4.entity.Cart;

public class CartData {

    private Long id;
    private String code;
    private UserData user;

    public CartData(){

    }

    public CartData(Long id, String code, UserData user) {
        this.id = id;
        this.code = code;
        this.user = user;
    }

    public CartData(Cart cart){
        this.id= cart.getId();
        this.code = cart.getCode();
        UserData userData = new UserData();
        userData.setId(cart.getUser().getId());
        userData.setName(cart.getUser().getName());
        this.user = userData;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public UserData getUser() {
        return user;
    }

    public void setUser(UserData user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "CartData{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", user=" + user +
                '}';
    }
}
