### JdbcTemplate

```java
RowMapper<T>
	//单行映射器
	public class SingleColumnRowMapper<T> implements RowMapper<T> {}
	//bean属性映射器
	public class BeanPropertyRowMapper<T> implements RowMapper<T> {}
	//多列映射器
	public class ColumnMapRowMapper implements RowMapper<Map<String, Object>> {}
```



```java
//用单个泛型对象来接收结果，要确保返回结果唯一，否则报错 
public <T> T queryForObject(String sql, RowMapper<T> rowMapper, @Nullable Object... args) 
//用单个泛型对象来接收结果，要确保返回结果唯一，否则报错 
public <T> T queryForObject(String sql, @Nullable Object[] args, RowMapper<T> rowMapper)
    
    
//用单个值来接收结果，如统计。要确保返回结果唯一，否则报错    
public <T> T queryForObject(String sql, Object[] args, Class<T> requiredType)
//用单个值来接收结果，如统计。要确保返回结果唯一，否则报错    
public <T> T queryForObject(String sql, Class<T> requiredType, @Nullable Object... args)    
    
//用单个map来接收结果，要确保返回结果唯一，否则报错    
public Map<String, Object> queryForMap(String sql, @Nullable Object... args) 

    
//用list来接收多行的单列的值    
public <T> List<T> queryForList(String sql, Class<T> elementType, @Nullable Object... args)

    
//用map集合来接收多个对象    
public List<Map<String, Object>> queryForList(String sql)   
//用map集合来接收多个对象      
public List<Map<String, Object>> queryForList(String sql, @Nullable Object... args)


//用泛型集合来接收多个对象    
public <T> List<T> query(String sql, RowMapper<T> rowMapper, @Nullable Object... args)
//用泛型集合来接收多个对象     
public <T> List<T> query(String sql, @Nullable Object[] args, RowMapper<T> rowMapper)
//用泛型集合来接收多个对象    
public <T> List<T> query(String sql, RowMapper<T> rowMapper) 
    
public int update(String sql, @Nullable Object... args)    
    
```

