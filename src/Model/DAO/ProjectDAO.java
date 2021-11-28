package Model.DAO;

import Connection.ConnectionFactory;
import Model.Project;
import Model.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProjectDAO {

    public void create(Project u) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            
            stmt = con.prepareStatement(
                "INSERT INTO projects_tb(project_name, project_description, project_owner) VALUES (?,?,?)"
            );
        
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getDescription());
            stmt.setInt(3, User.getId());
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            
            Logger.getLogger(ProjectDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        } finally {
            
            ConnectionFactory.closeConnection(con,stmt);
            
        }
    }
    
    public List<Project> read(){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Project> projects = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM projects_tb");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Project project = new Project();
                project.setId(rs.getInt("project_id"));
                project.setOwner(rs.getInt("project_owner"));
                project.setName(rs.getString("project_name"));
                project.setDescription(rs.getString("project_description"));
                projects.add(project);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return projects;
    }
    
    public Project readById(int p){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Project project = new Project();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM projects_tb WHERE project_id = ?");
            stmt.setInt(1, p);
            
            rs = stmt.executeQuery();
            if(rs.next()){
                project.setId(rs.getInt("project_id"));
                project.setName(rs.getString("project_name"));
                project.setDescription(rs.getString("project_description")); 
            }


            
            
        } catch (SQLException ex) {
            Logger.getLogger(ProjectDAO.class.getName()).log(Level.SEVERE, "AQUI", ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return project;
        
        
    }
    
    public void update(Project p) {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE projects_tb SET project_name = ?, project_description = ? WHERE project_id = ?");
            stmt.setString(1, p.getName());
            stmt.setString(2, p.getDescription());
            stmt.setInt(3, p.getId());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ProjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
    public void delete(Project p) {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM projects_tb WHERE project_id = ?");
            stmt.setInt(1, p.getId());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ProjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
}
