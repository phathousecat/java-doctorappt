import org.junit.rules.ExternalResource;
import org.sql2o.*;

public class DatabaseRule extends ExternalResource {

  protected void before() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/doctor_appts_test", null, null);
  }

  protected void after() {
    try(Connection con = DB.sql2o.open()){
      // String deleteTasksQuery = "DELETE FROM tasks *;";
      String deleteDoctorQuery = "DELETE FROM doctors *;";
      // con.createQuery(deleteTasksQuery).executeUpdate();
      con.createQuery(deleteDoctorQuery).executeUpdate();
    }
  }
}
