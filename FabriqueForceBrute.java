public class FabriqueForceBrute {
    public static ForceBrute getInstance(String type) {
        ForceBrute fBrute = null;
        if (type.equalsIgnoreCase("Combinnaison")) {
            fBrute = new ForceBruteCombinaison();
        } else if(type.equalsIgnoreCase("DICTIONAIRE")) {
            fBrute = new ForceBruteDictionnaire();
        }
        return fBrute;
    }
    
}
