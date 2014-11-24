
public enum StatusCode {

	USER_NOT_FOUND(-1),
	SERVICE_NOT_FOUND(-2),
	INCOMPLETE_REQUEST(-3),
	NOT_ALLOWED(-4);

    private int numVal;

   StatusCode(int numVal) {
        this.numVal = numVal;
    }

    public int getNumVal() {
        return numVal;
    } 
	
    public String getValue(int val) {
    	switch (val) {
		case -1:
			return "[Cannot find this user in database.]";
		case -2:
			return "[Cannot find this service in database.]";
		case -3:
			return "Incomplete Request";
		case -4:
			return "[Don't have access to this service.]";
		default:
			return null;
		}
    }
}
