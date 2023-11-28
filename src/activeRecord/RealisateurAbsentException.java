package activeRecord;

public class RealisateurAbsentException extends Exception {

    @Override
    public String getMessage() {
        return "Le realisateur n'existe pas";
    }
}
