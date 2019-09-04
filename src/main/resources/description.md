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
6.redis缓存
    * @CacheConfig全局配置缓存
    * @Cacheable(cacheNames, key, condition, unless):运行一次缓存后不再运行
        * key默认为传参,condition为判断传参是否符合条件,unless为判断返回结果是否符合
    * @CachePut():返回数据类型一致才能更新
    * @CacheEvict():清除缓存,每一次都运行