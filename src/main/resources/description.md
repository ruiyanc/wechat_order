####说明与差异
* 采用SpringBoot2.0 + thymeleaf
1. jdk1.8返回Optional对象,为空则返回null
    * return repository.findById(productId).orElse(null);
2. dataJPA2.0中分页
    * Pageable pageable = PageRequest.of(page, size);
3. thymeleaf中fori循环,使用numbers对象内置函数
    * th:each="index : ${#numbers.sequence(1, 5)}"
4. thymeleaf模板中新增和修改同一个界面时,新增时字段为空报错 
    * th:value="${result?.data?.menuName}"
5. JPA2.0 id字段自增
    * @GeneratedValue(strategy = GenerationType.IDENTITY)