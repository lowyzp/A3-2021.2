package Model.DAO;

import Connection.ConnectionFactory;
import Model.Requirement;
import Model.User;
import View.ProjectsRUD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RequirementDAO {

    public void create(Requirement r) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            
            stmt = con.prepareStatement(
                "INSERT INTO requirements_tb("
                        + "requirement_identifier, "
                        + "requirement_name, "
                        + "requirement_description, "
                        + "requirement_functionality, "
                        + "requirement_creation_date, "
                        + "requirement_update_date, "
                        + "requirement_version, "
                        + "requirement_priority, "
                        + "requirement_complexity, "
                        + "requirement_effort, "
                        + "requirement_state, "
                        + "requirement_stage, "
                        + "requirement_module, "
                        + "requirement_author, "
                        + "requirement_update_user"
                        + ") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"
            );
            stmt.setString(1, r.getIdentifier());
            stmt.setString(2, r.getName());
            stmt.setString(3, r.getDescription());
            stmt.setString(4, r.getFunctionality());
            stmt.setString(5, r.getCreationDate());
            stmt.setString(6, r.getUpdateDate());
            stmt.setString(7, r.getVersion());
            stmt.setString(8, r.getPriority());
            stmt.setString(9, r.getComplexity());
            stmt.setString(10, r.getEffort());
            stmt.setString(11, r.getState());
            stmt.setString(12, r.getStage());
            stmt.setInt(13, r.getModule());
            stmt.setInt(14, r.getAuthor());
            stmt.setInt(15, r.getUpdater());


            
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            
            Logger.getLogger(RequirementDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        } finally {
            
            ConnectionFactory.closeConnection(con,stmt);
            
        }
    }
    
    public List<Requirement> read(){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Requirement> requirements = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM requirements_tb WHERE requirement_module = ?");            
            stmt.setInt(1, ProjectsRUD.id);

            rs = stmt.executeQuery();
            
            while(rs.next()){
                Requirement requirement = new Requirement();
                
                requirement.setIdentifier(rs.getString("requirement_identifier"));
                requirement.setName(rs.getString("requirement_name"));
                requirement.setDescription(rs.getString("requirement_description"));
                requirement.setFunctionality(rs.getString("requirement_functionality"));
                requirement.setCreationDate(rs.getString("requirement_creation_date"));
                requirement.setUpdateDate(rs.getString("requirement_update_date"));
                requirement.setVersion(rs.getString("requirement_version"));
                requirement.setPriority(rs.getString("requirement_priority"));
                requirement.setComplexity(rs.getString("requirement_complexity"));
                requirement.setEffort(rs.getString("requirement_effort"));
                requirement.setState(rs.getString("requirement_state"));
                requirement.setStage(rs.getString("requirement_stage"));
                requirement.setId(rs.getInt("requirement_id"));
                requirement.setModule(rs.getInt("requirement_module"));
                requirement.setAuthor(rs.getInt("requirement_author"));
                requirement.setUpdater(rs.getInt("requirement_update_user"));
                
                requirements.add(requirement);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(RequirementDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return requirements;
    }
    
    public Requirement readById(int p){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Requirement requirement = new Requirement();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM requirements_tb WHERE requirement_id = ?");
            stmt.setInt(1, p);
            
            rs = stmt.executeQuery();
            if(rs.next()){                
                requirement.setIdentifier(rs.getString("requirement_identifier"));
                requirement.setName(rs.getString("requirement_name"));
                requirement.setDescription(rs.getString("requirement_description"));
                requirement.setFunctionality(rs.getString("requirement_functionality"));
                requirement.setCreationDate(rs.getString("requirement_creation_date"));
                requirement.setUpdateDate(rs.getString("requirement_update_date"));
                requirement.setVersion(rs.getString("requirement_version"));
                requirement.setPriority(rs.getString("requirement_priority"));
                requirement.setComplexity(rs.getString("requirement_complexity"));
                requirement.setEffort(rs.getString("requirement_effort"));
                requirement.setState(rs.getString("requirement_state"));
                requirement.setStage(rs.getString("requirement_stage"));
                requirement.setId(rs.getInt("requirement_id"));
                requirement.setModule(rs.getInt("requirement_module"));
                requirement.setAuthor(rs.getInt("requirement_author"));
                requirement.setUpdater(rs.getInt("requirement_update_user"));                
            }


            
            
        } catch (SQLException ex) {
            Logger.getLogger(RequirementDAO.class.getName()).log(Level.SEVERE, "AQUI", ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return requirement;
        
        
    }
    
    public void update(Requirement r) {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE requirements_tb SET "
                        + "requirement_identifier = ?, "
                        + "requirement_name = ?, "
                        + "requirement_description = ?, "
                        + "requirement_functionality = ?, "
                        + "requirement_version = ?, "
                        + "requirement_priority = ?, "
                        + "requirement_complexity = ?, "
                        + "requirement_effort = ?, "
                        + "requirement_state = ?, "
                        + "requirement_stage = ?, "
                        + "requirement_update_date = ?, "
                        + "requirement_update_user = ? "
                        + "WHERE requirement_id = ?");
            
            stmt.setString(1, r.getIdentifier());
            stmt.setString(2, r.getName());
            stmt.setString(3, r.getDescription());
            stmt.setString(4, r.getFunctionality());
            stmt.setString(5, r.getVersion());
            stmt.setString(6, r.getPriority());
            stmt.setString(7, r.getComplexity());
            stmt.setString(8, r.getEffort());
            stmt.setString(9, r.getState());
            stmt.setString(10, r.getStage());
            stmt.setString(11, r.getUpdateDate());
            stmt.setInt(12, r.getUpdater());
            stmt.setInt(13, Requirement.getStaticId());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(RequirementDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
        public void delete(int p) {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM requirements_tb WHERE requirement_id = ?");
            stmt.setInt(1, p);

            stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(RequirementDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
}
