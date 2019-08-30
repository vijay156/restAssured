package API_CALLS.SCRIPTS;

public class RegistrationSuccessResponse {
	
	public String FaultId;
	public String fault;
	
	public void faultId(String FaultId){
        this.FaultId = FaultId;
    }
    public String getFaultId(){
        return this.FaultId;
    }
    
    public void Fault(String fault){
        this.fault = fault;
    }
    public String getFault(){
        return this.fault;
    }

}
