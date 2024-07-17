package Exercice2.presentation;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import Exercice2.metier.Employe;

public class OperationsSurEmployes {
    public static void main(String[] args) {
        // Cr�er une liste d'employ�s
        List<Employe> employes = new ArrayList<>();
        employes.add(new Employe("jana", "Ressources humaines", 5000.0));
        employes.add(new Employe("hanane", "Informatique", 6000.0));
        employes.add(new Employe("malak", "Ventes", 5500.0));
        employes.add(new Employe("nour", "Finances", 7000.0));

        // 1. Utiliser mapToDouble et sum pour calculer la somme totale des salaires de tous les employ�s.
        double sommeSalaires = employes.stream()
                .mapToDouble(Employe::getSalaire)
                .sum();
        System.out.println("Somme totale des salaires : " + sommeSalaires);

        // 2. Utiliser sorted pour trier la liste des employ�s par ordre alphab�tique du nom.
        List<Employe> employesTriesParNom = employes.stream()
                .sorted(Comparator.comparing(Employe::getNom))
                .toList();
        System.out.println("Employ�s tri�s par nom : " + employesTriesParNom);

        // 3. Utiliser min pour trouver l'employ� avec le salaire le plus bas.
        employes.stream()
                .min(Comparator.comparing(Employe::getSalaire))
                .ifPresent(employe -> System.out.println("Employ� avec le salaire le plus bas : " + employe));

        // 4. Utiliser filter pour obtenir la liste des employ�s ayant un salaire sup�rieur � une valeur donn�e.
        double seuilSalaire = 55000.0;
        List<Employe> employesSalairesSup = employes.stream()
                .filter(employe -> employe.getSalaire() > seuilSalaire)
                .toList();
        System.out.println("Employ�s avec un salaire sup�rieur � " + seuilSalaire + " : " + employesSalairesSup);

        // 5. Utiliser reduce pour trouver l'employ� avec le salaire le plus �lev� dans l'ensemble de l'entreprise.
        employes.stream()
                .reduce((e1, e2) -> e1.getSalaire() > e2.getSalaire() ? e1 : e2)
                .ifPresent(employe -> System.out.println("Employ� avec le salaire le plus �lev� : " + employe));

        // 6. Utiliser reduce pour concat�ner les noms de tous les employ�s.
        String nomsConcatenes = employes.stream()
                .map(Employe::getNom)
                .reduce("", (nom1, nom2) -> nom1 + ", " + nom2);
        System.out.println("Noms concat�n�s : " + nomsConcatenes);
    }
}