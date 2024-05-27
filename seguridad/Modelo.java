import java.util.List;
import java.util.Random;

public class Modelo {
    public static void main(String[] args) {
        Random rand = new Random();

        // Crear nodos con valores aleatorios
        AttackTreeNode root = new AttackTreeNode("Virus infects a file", generateRandomCost(rand), generateRandomProbability(rand));
        
        // Nivel 1
        AttackTreeNode adminRun = new AttackTreeNode("Virus run as an administrator", generateRandomCost(rand), generateRandomProbability(rand));
        AttackTreeNode normalRun = new AttackTreeNode("Virus run as normal user", generateRandomCost(rand), generateRandomProbability(rand));
        
        root.addChild(adminRun);
        root.addChild(normalRun);
        
        // Nivel 2 para "Virus run as an administrator"
        AttackTreeNode exploitRoot = new AttackTreeNode("Virus exploits root hole", generateRandomCost(rand), generateRandomProbability(rand));
        AttackTreeNode adminRunAdmin = new AttackTreeNode("Virus run by an admin", generateRandomCost(rand), generateRandomProbability(rand));
        
        adminRun.addChild(exploitRoot);
        adminRun.addChild(adminRunAdmin);
        
        // Nivel 3 para "Virus exploits root hole"
        AttackTreeNode otherInfectedPrograms1 = new AttackTreeNode("Other infected programs", generateRandomCost(rand), generateRandomProbability(rand));
        exploitRoot.addChild(otherInfectedPrograms1);
        
        // Nivel 3 para "Virus run by an admin"
        AttackTreeNode infectsInstallPackage = new AttackTreeNode("Virus infects install package", generateRandomCost(rand), generateRandomProbability(rand));
        adminRunAdmin.addChild(infectsInstallPackage);
        
        // Nivel 2 para "Virus run as normal user"
        AttackTreeNode otherInfectedPrograms2 = new AttackTreeNode("Other infected programs", generateRandomCost(rand), generateRandomProbability(rand));
        AttackTreeNode userDownloads = new AttackTreeNode("User downloads and runs infected naked binary", generateRandomCost(rand), generateRandomProbability(rand));
        
        normalRun.addChild(otherInfectedPrograms2);
        normalRun.addChild(userDownloads);
        
        // Nivel 3 para "User downloads and runs infected naked binary"
        AttackTreeNode adminDownloads = new AttackTreeNode("Admin downloads and runs infected naked binary", generateRandomCost(rand), generateRandomProbability(rand));
        userDownloads.addChild(adminDownloads);
        
        // Crear el árbol de ataque
        AttackTree attackTree = new AttackTree(root);

        // Calcular el riesgo total
        double totalRisk = attackTree.calculateTotalRisk();
        System.out.println("Total Risk: " + totalRisk);

        // Encontrar y mostrar la ruta crítica
        List<AttackTreeNode> criticalPath = attackTree.findCriticalPath();
        System.out.print("Critical Path: ");
        for (AttackTreeNode node : criticalPath) {
            System.out.print(node.getDescription() + " -> ");
        }
    }

    private static double generateRandomCost(Random rand) {
        return 100 + (900 * rand.nextDouble()); // Valores entre 100 y 1000
    }

    private static double generateRandomProbability(Random rand) {
        return 0.1 + (0.9 * rand.nextDouble()); // Valores entre 0.1 y 1.0
    }
}
