package Exercice1.presentation;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class OperationsSurMots {
    public static void main(String[] args) {
        List<String> mots = Arrays.asList("Java", "Python", "C#", "JavaScript", "Ruby");

        // 1. Filtrer les mots qui contiennent la lettre "a".
        List<String> motsAvecA = mots.stream()
                .filter(mot -> mot.contains("a"))
                .toList();
        System.out.println("Mots contenant la lettre 'a': " + motsAvecA);

        // 2. Filtrer les mots qui ont une longueur sup�rieure � 3 et transformer chaque mot en son inverse.
        List<String> motsInverseLongueurSup3 = mots.stream()
                .filter(mot -> mot.length() > 3)
                .map(mot -> new StringBuilder(mot).reverse().toString())
                .toList();
        System.out.println("Mots invers�s de longueur sup�rieure � 3: " + motsInverseLongueurSup3);

        // 3. Filtrer les cha�nes qui contiennent la lettre "e" et aplatir chaque cha�ne en une liste de ses caract�res.
        List<Character> caracteresContenantE = mots.stream()
                .filter(chaine -> chaine.contains("e"))
                .flatMap(chaine -> chaine.chars().mapToObj(c -> (char) c))
                .toList();
        System.out.println("Caract�res des cha�nes contenant la lettre 'e': " + caracteresContenantE);

        // 4. Transformer chaque cha�ne en sa version en majuscules.
        List<String> majuscules = mots.stream()
                .map(String::toUpperCase)
               .toList();
        System.out.println("Mots en majuscules: " + majuscules);

        // 5. Convertir chaque cha�ne en sa longueur.
        List<Integer> longueurs = mots.stream()
                .map(String::length)
                .toList();
        System.out.println("Longueurs des mots: " + longueurs);

        // 6. Transformer chaque cha�ne en une liste de ses caract�res, puis aplatir toutes les listes en une seule liste de caract�res.
        List<Character> tousCaracteres = mots.stream()
                .flatMap(chaine -> chaine.chars().mapToObj(c -> (char) c))
                .toList();
        System.out.println("Tous les caract�res: " + tousCaracteres);

        // 7. � partir d'une liste de mots, transformer chaque nom en une cha�ne de la forme "Nom - Index".
        List<String> nomsAvecIndex = IntStream.range(0, mots.size())
                .mapToObj(i -> mots.get(i) + " - " + i)
                .toList();
        System.out.println("Noms avec index : " + nomsAvecIndex);
    }
}
