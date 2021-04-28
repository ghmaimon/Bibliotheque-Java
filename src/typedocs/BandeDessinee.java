package typedocs;

public class BandeDessinee extends Document{
    
        // ************** attributes:
    
        private final boolean coloree;
        private String genre;
    
        // ************** getters et setters:
    
        public boolean get_coloree() {
            return coloree;
        }

        public String get_genre() {
            return genre;
        }
        public void set_genre(String genre) {
            this.genre = genre;
        }
    
        // ************** methods:
    
        public String toString() {
            String representation = super.toString();
            representation += "\nnombre des pages: ";
            representation += coloree?"\ncoloree":"\nn'est pas coloree";
            return representation;
        }
        
        // ************** Constructeur:
    
        public BandeDessinee(int ISBN,String titre,String auteurs,String editeur,String AneEdition,int numExemplaires,boolean colore,String genre) {
            super(ISBN, titre, auteurs, editeur, AneEdition, numExemplaires);
            this.coloree = colore;
            this.genre = genre;
        }
}
