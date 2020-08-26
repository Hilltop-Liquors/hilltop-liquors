//package com.codeup.hilltopliquors.znotes;
//
//public class notes {
//}
//    New fixed form test/cart
//
//        Cart controller______________________________
//        package com.codeup.hilltopliquors.controllers;
//        import com.codeup.hilltopliquors.models.Order;
//        import com.codeup.hilltopliquors.models.OrderProduct;
//        import com.codeup.hilltopliquors.models.Product;
//        import com.codeup.hilltopliquors.models.User;
//        import com.codeup.hilltopliquors.repositories.*;
//        import com.codeup.hilltopliquors.security.UserRegistrationDto;
//        import org.springframework.security.core.context.SecurityContextHolder;
//        import org.springframework.stereotype.Controller;
//        import org.springframework.ui.Model;
//        import org.springframework.web.bind.annotation.*;
//
//        import java.sql.SQLOutput;
//        import java.sql.Timestamp;
//        import java.time.Instant;
//        import java.util.ArrayList;
//        import java.util.List;
//
//
//@Controller
//@SessionAttributes("cart")
//public class CartController {
//
//
//    private final OrderRepository orderDao;
//    private final ProductRepository productDao;
//    private final SubcategoryRepository subCatDao;
//    private final CategoryRepository catDao;
//    private final ProductTypeRepository productTypeDao;
//    private final UserRepository userDao;
//    private final OrderProductRepository orderProductDao;
//
//    public CartController(OrderRepository orderDao, ProductRepository productDao, SubcategoryRepository subCatDao, CategoryRepository catDao, ProductTypeRepository productTypeDao, UserRepository userDao, OrderProductRepository orderProductDao) {
//        this.orderDao = orderDao;
//        this.productDao = productDao;
//        this.subCatDao = subCatDao;
//        this.catDao = catDao;
//        this.productTypeDao = productTypeDao;
//        this.userDao = userDao;
//        this.orderProductDao = orderProductDao;
//    }
//
//
//    @ModelAttribute("cart")
//    public Order order() {
//        Order newOrder = new Order();
////        User user =(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//
////
////        Instant instant = Instant.now();
////        Timestamp timestamp = Timestamp.from(instant);
////        newOrder.setCreatedAt(timestamp);
//
//
////        newOrder.setUser(user);
//
////        List <OrderProduct> cart = new ArrayList<>();
//
//
//        return newOrder;
//    }
//
//    @PostMapping("/add/{id}")
//    public String addToCart(Model vModel, @PathVariable("id") final Long id, @ModelAttribute("cart") Order order, final Model model) {
//
//
////        System.out.println(newOrder.getId() + " " + newOrder.getCreatedAt());
////        User user =(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//
//        Product product = productDao.getOne(id);
//
////
////        Order newOrder = new Order();
////
////
////
////        Instant instant = Instant.now();
////        Timestamp timestamp = Timestamp.from(instant);
////        newOrder.setCreatedAt(timestamp);
////        newOrder.setUser(user);
////
////        orderDao.save(newOrder);
//
//
////        List<OrderProduct> cartList = order.getOrderProducts();
//
//        if (order.getOrderProducts() != null) {
//            OrderProduct orderProduct = new OrderProduct();
//            orderProduct.setProduct(product);
//            orderProduct.setQuantity(1);
//            order.getOrderProducts().add(orderProduct);
////            order.setOrderProducts(cart);
//            model.addAttribute("cart", order);
//            System.out.println(order.getOrderProducts().size());
//            for (OrderProduct items : order.getOrderProducts()) {
//                System.out.println("this is the name : " + items.getProduct().getName());
//            }
//
//
//        } else {
////            List<OrderProduct> cart = new ArrayList<>();
////            cart.add(orderProduct);
//            OrderProduct orderProduct = new OrderProduct();
//            orderProduct.setProduct(product);
//            orderProduct.setQuantity(1);
//
//            Order newOrder = new Order();
//            newOrder.addOrderProducts(orderProduct);
//
////            newOrder.setOrderProducts(cart);
//            model.addAttribute("cart", newOrder);
//            System.out.println(newOrder.getOrderProducts().size());
//
//            for (OrderProduct items : newOrder.getOrderProducts()) {
//                System.out.println(items.getProduct().getName());
//            }
//
//
//        }
//
//
////            orderProduct.setOrder(newOrder);
//
//
////            orderProductDao.save(orderProduct);
//
////            newOrder.setOrderProducts(cart);
//
//
////            vModel.addAttribute("newOrder" ,newOrder);
////        vModel.addAttribute("cart" ,cartList);
//
//
//        return "search/search";
//
//    }
//
//    @GetMapping("/Cart")
//    public String showCart(Model vModel, @SessionAttribute("cart") Order order, final Model model) {
//
//
//        List<OrderProduct> orderProducts = order.getOrderProducts();
//
//
////        order.getOrderProducts()
////        if (order == null) {
////
////
//        model.addAttribute("cart", orderProducts);
////        }else{
//        vModel.addAttribute("order", new Order());
////        }
//        return "cart";
//    }
//}
//
//
//    Cart himl _____________________________
//<!DOCTYPE html>
//<html xmlns:th="http://www.thymeleaf.org" lang="en">
//<head th:include="partials/head :: head">
//<title>Hilltop-Cart</title>
//
//<style>
//        nav {
//                height: 70px !important;
//                }
//
//</style>
//
//</head>
//<body>
//<nav th:replace="partials/navbar :: navbar"></nav>
//
//<div class="container m-5 p-5">
//
//<div id="w">
//<header id="title">
//<!--            <h1 th:text="${username}"></h1>-->
//<br>
//</header>
//<div id="page">
//<table id="cart">
//<thead>
//<tr>
//<th class="first">Photo</th>
//<th class="second">Qty</th>
//<th class="third">Product</th>
//<th class="fourth">Line Total</th>
//<th class="fifth">&nbsp;</th>
//</tr>
//</thead>
//<tbody>
//<!-- shopping cart contents -->
//
//<!--                <div th:if="${cart != null}">-->
//<div th:each="cartItem : ${cart}">
//<tr class="productitm">
//<!-- http://www.inkydeals.com/deal/ginormous-bundle/ -->
//
//
//<td><img src="../static/img/filler_bottle.png" class="thumb"></td>
//<td><input type="number" th:value="${cartItem.quantity}" min="0" max="99" class="qtyinput"></td>
//<td th:text="${cartItem.getProduct().getName()}"><span class="pl-1 pr-1"
//        style="font-weight: lighter"></span>
//</td>
//<!--                        <td th:text="${cartItem.getProduct().getPriceInCents()}"></td>-->
//<td><span class="remove"><img src="https://i.imgur.com/h1ldGRr.png" alt="X"></span></td>
//</tr>
//
//</div>
//
//<!--                </div>-->
//
//<!--                <div th:else><h1> Your Cart Is Empty</h1></div>-->
//
//<form th:action="@{/cart/checkout}" th:object="${order}">
//<!-- checkout btn -->
//<tr class="checkoutrow">
//<td colspan="5" class="checkout">
//<button class="bg-dark text-white" type="submit">Checkout</button>
//<a class="float-right" style="text-decoration: none; color:black;" th:href="@{/Home}">back</a>
//</td>
//</tr>
//
//
//</form>
//</tbody>
//</table>
//</div>
//</div>
//<!--     CITATION: https://codepen.io/BryanBanda/pen/yoGnj   -->
//
//</div>
//
//
//<footer th:replace="partials/footer :: footer"></footer>
//</body>
//</html>
//
//        Search html_____________________________
//<!DOCTYPE html>
//<html xmlns:th="http://www.thymeleaf.org" lang="en">
//<head th:include="partials/head :: head">
//<title>Hilltop-Search</title>
//
//<style>
//        nav {
//                height: 70px !important;
//                }
//</style>
//
//</head>
//<body>
//
//<!--  TOP NAV  -->
//<nav th:replace="partials/navbar :: navbar"></nav>
//
//<!--  CONTAINER  -->
//<div class="row mt-5" style="width:100%;">
//
//<!--  SIDE NAV  -->
//<!--  CITATION: https://coreui.io/docs/getting-started/download/#source-files  -->
//<div th:fragment="side-nav" class="col-md-2 c-sidebar c-sidebar-dark c-sidebar-show fixed-top navbar-expand-md"
//        style="margin-top: 55px; height: 100%; z-index: 1;">
//
//<!--  SEARCH BAR  -->
//<form class="center ml-2 d-inline mt-5" th:action="@{/Search}" method="get">
//<input id="txtSearch" type="text" name="keyword">
//</form>
//
//<!--  LIQUOR  -->
//<ul class="c-sidebar-nav">
//<li class="c-sidebar-nav-title">Browse by category</li>
//
//<!--    PRODUCT TYPE SIDE-NAV DISPLAY    -->
//<li class="c-sidebar-nav-item" style="color: black; text-decoration: none;"
//        th:each="productType : ${productTypes}">
//<a th:href="@{/Search}" th:value="${productType.getId()}">
//<form class="c-sidebar-nav-link" th:action="@{/Search}" method="get">
//<input type="hidden" name="productCat" th:value="${productType.getId()}">
//<p th:text="${productType.getName()}"></p>
//
//</form>
//</a>
//
//<!--    CATEGORY SIDE-NAV DISPLAY   -->
//<!--                    <ul>-->
//<!--                        <li th:each="category : ${categories}">-->
//<!--                            <a class="c-sidebar-nav-link" style="color: black; text-decoration: none;"-->
//<!--                               th:href="@{/Search}"-->
//<!--                               th:value="${category.getId()}">-->
//<!--                                <p th:text="${category.getName()}"></p>-->
//<!--                            </a>-->
//<!--                        </li>-->
//<!--                    </ul>-->
//
//</li>
//</ul>
//</div>
//
//<!--  SEARCH KEYWORD RENDERED  -->
//<h2 style="margin-left: 20%; margin-top: 52px; width:100%; z-index:1000; background-color: #EBEDEF;"
//class="fixed-top pb-4 pt-3">
//<span th:text="${keyword}" style="border-bottom: 2px solid #3a4a67;"></span>
//</h2>
//
//<!--SHOW ALL PRODUCTS-->
//<div class="col-md-9" style="width: 100%; margin-left: 10%; z-index: 1; margin-top: 5%;">
//<div th:each="product : ${products}" class="card col-md-3 m-3 shadow p-3 bg-white rounded float-right">
//<a style="color: black; text-decoration: none;" th:href="@{/Search/{id}(id=${product.id})}"
//        th:value="${product.id}">
//<div class="card-header bg-dark text-white center"
//        style="border-bottom: 4px solid maroon; ">
//<img class="center" style="width: 126px; height: 189px;" src="../static/img/filler_bottle.png"
//        th:src="@{img/filler_bottle.png}" alt="bottle"/>
//</div>
//</a>
//<div class="card-body d-flex flex-column">
//<p th:text="${product.name}"></p>
//<p th:text="${product.priceInCents}"></p>
//<form th:action ="@{/add/{productId}(productId= ${product.id})}" th:method="post">
//<button style="border-left: 4px solid maroon;" class="bg-dark text-white">Add to Cart</button>
//</form>
//<hr>
//<p style="font-weight: lighter; font-size: smaller"><i>tags</i></p>
//
//
//
//<button style="color:black; font-size: smaller;" class="mt-auto btn btn-light"
//        th:text="${product.getSubCategory().getCategory().getProductType().getName()}">
//</button>
//</div>
//</div>
//</div>
//
//</div>
//<footer th:replace="partials/footer :: footer"></footer>
//</body>
//</html>
//
//
//        order.java_____________________________
//        package com.codeup.hilltopliquors.models;
//
//
//        import org.apache.commons.collections.CollectionUtils;
//
//        import javax.persistence.*;
//        import java.sql.Timestamp;
//        import java.util.ArrayList;
//        import java.util.List;
//
//@Entity
//@Table(name = "orders")
//public class Order {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//
//    @Column(length = 250, nullable = false)
//    private int totalInCents;
//
//    @Column(length = 250, nullable = false)
//    private boolean isCurbside;
//
//    @Column(length = 250, nullable = false)
//    private Timestamp createdAt;
//
//    @Column(length = 250, nullable = false)
//    private  boolean orderIsFulfilled;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "users_id", referencedColumnName = "id")
//    private User user;
//
//    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
//    private List<OrderProduct> orderProducts;
//
//
//
//    public Order() {
//    }
//
//    public Order(long id, int totalInCents, boolean isCurbside, Timestamp createdAt, boolean orderIsFulfilled) {
//        this.id = id;
//        this.totalInCents = totalInCents;
//        this.isCurbside = isCurbside;
//        this.createdAt = createdAt;
//        this.orderIsFulfilled = orderIsFulfilled;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public int getTotalInCents() {
//        return totalInCents;
//    }
//
//    public void setTotalInCents(int totalInCents) {
//        this.totalInCents = totalInCents;
//    }
//    public boolean getIsCurbside() {
//        return isCurbside;
//    }
//
//    public void setIsCurbside(boolean isCurbside) {
//        this.isCurbside = isCurbside;
//    }
//    public Timestamp getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(Timestamp createdAt) {
//        this.createdAt = createdAt;
//    }
//    public boolean getOrderIsFulfilled() {
//        return orderIsFulfilled;
//    }
//
//    public void setOrderIsFulfilled(boolean orderIsFulfilled) {
//        this.orderIsFulfilled = orderIsFulfilled;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public List<OrderProduct> getOrderProducts() {
//        return orderProducts;
//    }
//
//    public void setOrderProducts(List<OrderProduct> orderProducts) {
//        this.orderProducts = orderProducts;
//    }
//
//    public void addOrderProducts(OrderProduct orderProduct){
//
//        if (CollectionUtils.isEmpty(this.getOrderProducts())) {
//            List <OrderProduct> products = new ArrayList< >();
//            products.add(orderProduct);
//            this.setOrderProducts(products);
//        } else {
//            this.orderProducts.add(orderProduct);
//        }
//
//    }
//
////    public OrderProduct getOrderProduct() {
////        return orderProduct;
////    }
////
////    public void setOrderProduct(OrderProduct orderProduct) {
////        this.orderProduct = orderProduct;
////    }
//}
//
//Orderproduct.java_____________________________
//        package com.codeup.hilltopliquors.models;
//
//        import javax.persistence.*;
//        import java.util.List;
//
//@Entity
//@Table(name = "order_product")
//public class OrderProduct {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//
//    @Column(length = 250, nullable = false)
//    private int quantity;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "orders_id", referencedColumnName = "id")
//    private Order order;
//
////    @OneToMany(mappedBy = "orderProduct", cascade = CascadeType.ALL)
////    private List<Product> products;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "product_id", referencedColumnName = "id")
//    private Product product;
//
//    public OrderProduct() {
//    }
//
//    public OrderProduct(long id, int quantity, Order order, Product product) {
//        this.id = id;
//        this.quantity = quantity;
//        this.order = order;
//        this.product = product;
//    }
//
//    public Order getOrder() {
//        return order;
//    }
//
//    public void setOrder(Order order) {
//        this.order = order;
//    }
//
//    public Product getProduct() {
//        return product;
//    }
//
//    public void setProduct(Product product) {
//        this.product = product;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//    public int getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(int quantity) {
//        this.quantity = quantity;
//    }
//}
//
//
//Orderprofuctrepo_____________________________
//        package com.codeup.hilltopliquors.repositories;
//
//        import com.codeup.hilltopliquors.models.Order;
//        import com.codeup.hilltopliquors.models.OrderProduct;
//        import com.codeup.hilltopliquors.models.ProductType;
//        import org.springframework.data.jpa.repository.JpaRepository;
//        import org.springframework.stereotype.Repository;
//
//        import java.util.List;
//
//@Repository
//public interface OrderProductRepository  extends JpaRepository<OrderProduct, Long> {
//
//}
//
//
//    Order repo_____________________________ 
//        package com.codeup.hilltopliquors.repositories;
//
//
//        import com.codeup.hilltopliquors.models.Order;
//        import org.springframework.data.jpa.repository.JpaRepository;
//        import org.springframework.stereotype.Repository;
//
//@Repository
//public interface OrderRepository extends JpaRepository<Order, Long> {
//}