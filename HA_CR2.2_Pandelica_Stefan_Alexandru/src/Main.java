public class Main {
    public static void main(String[] args) {
        int[][] distances = {
                {0, 534, 0, 434, 107, 0, 294, 241, 148, 0, 593, 190, 137, 374, 0, 409, 351, 240,},
                {190, 258, 0, 332, 320, 232, 139, 494, 310, 0, 232, 354, 261, 113, 372, 188, 208, 0,},
                {464, 124, 88, 171, 202, 328, 188, 284, 0, 566, 508, 397, 347, 331, 171, 467, 345, 485,},
                {0, 552, 80, 127, 259, 234, 365, 249, 372, 61, 522, 0, 802, 316, 336, 509, 222, 470,},
                {588, 584, 392, 502, 386, 0, 633, 432, 479, 552, 586, 723, 417, 621, 411, 874, 354, 738,},
                {0, 257,  641,  541,  407,  706,  522,  184,  391,  372, 679, 433, 915, 390, 0, 187, 507, 477,},
                {437, 539, 525, 775, 572, 196, 88, 77, 351, 339, 411, 328, 583, 279, 483, 205, 450, 242,},
                {498, 63, 0, 130, 520, 427, 280, 579, 395, 318, 264, 450, 552, 538, 788, 543, 167, 59,},
                {551, 850, 6, 474, 535, 662, 823, 723, 1059, 524, 238, 238, 372, 303, 138, 126, 248, 867,},
                {101, 649, 489, 165, 526, 782, 256, 340, 311, 0, 134, 524, 431, 284, 583, 399, 314, 268,},
                {454, 556, 542, 792, 530, 154, 63, 105, 309, 297, 369, 286, 600, 237, 500, 222, 408, 259},

        };



        // Breadth-First Search
        TSPSolverBFS solverBFS = new TSPSolverBFS(distances);
        Result resultBFS = solverBFS.solve();
        System.out.println("BFS solution: " + resultBFS);

        // Uniform Cost Search
        TSPSolverUCS solverUCS = new TSPSolverUCS(distances);
        Result resultUCS = solverUCS.solve();
        System.out.println("UCS solution: " + resultUCS);

        // A* Search
        TSPSolverAStar solverAStar = new TSPSolverAStar(distances);
        Result resultAStar = solverAStar.solve();
        System.out.println("A* solution: " + resultAStar);
    }
}
