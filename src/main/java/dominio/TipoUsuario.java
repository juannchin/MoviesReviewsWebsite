
package dominio;


public class TipoUsuario {
     private int idTipoUsuario;
    private String userType;

    public TipoUsuario() {
    }

    public TipoUsuario(int idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public TipoUsuario(String userType) {
        this.userType = userType;
    }

    public TipoUsuario(int idTipoUsuario, String userType) {
        this.idTipoUsuario = idTipoUsuario;
        this.userType = userType;
    }

    public int getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(int idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "TipoUsuario{" + "idTipoUsuario=" + idTipoUsuario + ", userType=" + userType + '}';
    }
    
    
}
