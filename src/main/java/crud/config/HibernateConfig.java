/*
 * package crud.config; import java.util.ArrayList; import java.util.List;
 * 
 * import org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.orm.hibernate5.LocalSessionFactoryBean;
 * 
 * import crud.model.Admin; import crud.model.Student;
 * 
 * @Configuration public class HibernateConfig {
 * 
 * @Bean public LocalSessionFactoryBean sessionFactory() {
 * LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
 * sessionFactory.setDataSource(dataSource());
 * sessionFactory.setAnnotatedClasses(getAnnotatedClasses()); return
 * sessionFactory; }
 * 
 * private Class<?>[] getAnnotatedClasses() { List<Class<?>> annotatedClasses =
 * new ArrayList<Class<?>>(); annotatedClasses.add(Student.class);
 * annotatedClasses.add(Admin.class); return annotatedClasses.toArray(new
 * Class<?>[annotatedClasses.size()]); }
 * 
 * // other methods for configuring data source, transaction manager, etc.
 * 
 * }
 */