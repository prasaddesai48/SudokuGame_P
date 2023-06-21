
import java.awt.*;
import java.util.*;

import javax.swing.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author Prasad Desai
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    private String Selected = "1";
    private boolean seeSolution = false;
    private boolean isPredefinedSet = false;
    Color emptyPresetColor = new Color(255, 255, 255);
    Color emptyPresetColorText = new Color(0, 0, 0);
    Color fullPresetColor = new Color(255, 0, 255);
    Color fullPresetColorText = new Color(0, 0, 0);
    Color numSelected = new Color(98, 101, 103);
    Color numUnselected = new Color(0, 0, 0);
    Color numSelectedText = new Color(255, 255, 255);
    Color numUnselectedText = new Color(255, 255, 255);
    Color sol = new Color(241, 196, 15);
    Color solText = new Color(0, 0, 0);
    Color wrong = new Color(198, 40, 40);
    Color wrongText = new Color(255, 255, 255);
    Color right = new Color(27, 94, 32);
    Color rightText = new Color(255, 255, 255);
    private ArrayList<JButton> predefinedBtns = new ArrayList<>();
    private String unSolvedBoardBlock[][] = {
            { "", "", "", "4", "", "", "7", "5", "6" },
            { "5", "", "", "", "7", "8", "", "4", "" },
            { "7", "3", "4", "5", "", "9", "", "2", "" },
            { "", "", "", "", "3", "4", "", "6", "" },
            { "", "3", "5", "", "", "", "1", "8", "" },
            { "", "9", "", "2", "8", "", "", "", "" },
            { "", "4", "", "3", "", "", "6", "8", "9" },
            { "", "5", "", "9", "6", "", "", "", "1" },
            { "9", "", "6", "", "", "2", "", "", "" }
    };
    private String solvedBoardBlock[][] = {
            { "2", "9", "8", "4", "1", "3", "7", "5", "6" },
            { "5", "1", "6", "2", "7", "8", "3", "4", "9" },
            { "7", "3", "4", "5", "6", "9", "1", "2", "8" },
            { "8", "2", "1", "5", "3", "4", "9", "6", "7" },
            { "4", "3", "5", "6", "9", "7", "1", "8", "2" },
            { "6", "9", "7", "2", "8", "1", "3", "4", "5" },
            { "1", "4", "2", "3", "7", "5", "6", "8", "9" },
            { "8", "5", "3", "9", "6", "4", "7", "2", "1" },
            { "9", "7", "6", "8", "1", "2", "4", "5", "3" }
    };
    private String unSolvedBoardRow[][] = {
            { "", "", "", "5", "", "", "7", "3", "4" },
            { "4", "", "", "", "7", "8", "5", "", "9" },
            { "7", "", "6", "", "4", "", "", "2", "" },
            { "", "", "", "", "3", "5", "", "9", "" },
            { "", "3", "4", "", "", "", "2", "8", "" },
            { "", "6", "", "1", "8", "", "", "", "" },
            { "", "4", "", "", "5", "", "9", "", "6" },
            { "3", "", "", "9", "6", "", "", "", "2" },
            { "6", "8", "9", "", "", "1", "", "", "" }
    };
    private String solvedBoardRow[][] = {
            { "2", "9", "8", "5", "1", "6", "7", "3", "4" },
            { "4", "1", "3", "2", "7", "8", "5", "6", "9" },
            { "7", "5", "6", "3", "4", "9", "1", "2", "8" },
            { "8", "2", "1", "4", "3", "5", "6", "9", "7" },
            { "5", "3", "4", "6", "9", "7", "2", "8", "1" },
            { "9", "6", "7", "1", "8", "2", "3", "4", "5" },
            { "1", "4", "2", "8", "5", "3", "9", "7", "6" },
            { "3", "7", "5", "9", "6", "4", "8", "1", "2" },
            { "6", "8", "9", "7", "2", "1", "4", "5", "3" }
    };

    private String resetBoardRow[][] = copyArray(unSolvedBoardRow);
    private String resetBoardBlock[][] = copyArray(unSolvedBoardBlock);
    private javax.swing.JButton[][] buttonsArray;

    private String[][] copyArray(String[][] oldArray) {
        String[][] newArray = new String[9][9];
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                newArray[i][j] = oldArray[i][j];
        return newArray;
    }

    private void changeSelected(String num) {
        switch (Selected) {
            case "1":
                num1.setBackground(numUnselected);
                num1.setForeground(numUnselectedText);
                break;
            case "2":
                num2.setBackground(numUnselected);
                num2.setForeground(numUnselectedText);
                break;
            case "3":
                num3.setBackground(numUnselected);
                num3.setForeground(numUnselectedText);
                break;
            case "4":
                num4.setBackground(numUnselected);
                num4.setForeground(numUnselectedText);
                break;
            case "5":
                num5.setBackground(numUnselected);
                num5.setForeground(numUnselectedText);
                break;
            case "6":
                num6.setBackground(numUnselected);
                num6.setForeground(numUnselectedText);
                break;
            case "7":
                num7.setBackground(numUnselected);
                num7.setForeground(numUnselectedText);
                break;
            case "8":
                num8.setBackground(numUnselected);
                num8.setForeground(numUnselectedText);
                break;
            case "9":
                num9.setBackground(numUnselected);
                num9.setForeground(numUnselectedText);
                break;
        }
        switch (num) {
            case "1":
                num1.setBackground(numSelected);
                num1.setForeground(numSelectedText);
                Selected = "1";
                break;
            case "2":
                num2.setBackground(numSelected);
                num2.setForeground(numSelectedText);
                Selected = "2";
                break;
            case "3":
                num3.setBackground(numSelected);
                num3.setForeground(numSelectedText);
                Selected = "3";
                break;
            case "4":
                num4.setBackground(numSelected);
                num4.setForeground(numSelectedText);
                Selected = "4";
                break;
            case "5":
                num5.setBackground(numSelected);
                num5.setForeground(numSelectedText);
                Selected = "5";
                break;
            case "6":
                num6.setBackground(numSelected);
                num6.setForeground(numSelectedText);
                Selected = "6";
                break;
            case "7":
                num7.setBackground(numSelected);
                num7.setForeground(numSelectedText);
                Selected = "7";
                break;
            case "8":
                num8.setBackground(numSelected);
                num8.setForeground(numSelectedText);
                Selected = "8";
                break;
            case "9":
                num9.setBackground(numSelected);
                num9.setForeground(numSelectedText);
                Selected = "9";
                break;
        }
    }

    private void performAction(javax.swing.JButton Button, int i, int j) {
        if (!seeSolution) {
            unSolvedBoardBlock[i][j] = Selected;
            if (Button.getBackground() == fullPresetColor)
                JOptionPane.showMessageDialog(this, "This place is already allocated!!", "Message",
                        JOptionPane.INFORMATION_MESSAGE);
            else {
                Button.setText(Selected);
                Button.setBackground(emptyPresetColor);
                Button.setForeground(emptyPresetColorText);
            }
        }
    }

    private void setButtons() {
        for (int i = 0; i < unSolvedBoardBlock.length; i++)
            for (int j = 0; j < unSolvedBoardBlock[0].length; j++) {
                buttonsArray[i][j].setText(unSolvedBoardBlock[i][j]);
                if (unSolvedBoardBlock[i][j] != "") {
                    if (!isPredefinedSet)
                        predefinedBtns.add(buttonsArray[i][j]);
                    buttonsArray[i][j].setBackground(fullPresetColor);
                    buttonsArray[i][j].setForeground(fullPresetColorText);
                } else {
                    buttonsArray[i][j].setBackground(emptyPresetColor);
                    buttonsArray[i][j].setForeground(emptyPresetColorText);
                }
            }
        isPredefinedSet = true;
    }

    private void toggleSolution() {
        if (seeSolution) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (!predefinedBtns.contains(buttonsArray[i][j])) {
                        buttonsArray[i][j].setText(solvedBoardBlock[i][j]);
                        buttonsArray[i][j].setBackground(sol);
                        buttonsArray[i][j].setForeground(solText);
                    }
                }
            }
            SolutionBtn.setText("Hide Sol");
        } else {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (!predefinedBtns.contains(buttonsArray[i][j])) {
                        buttonsArray[i][j].setText(unSolvedBoardBlock[i][j]);
                        buttonsArray[i][j].setBackground(emptyPresetColor);
                        buttonsArray[i][j].setForeground(emptyPresetColorText);
                    }
                }
            }
            SolutionBtn.setText("Solution");
        }
    }

    private void checkMoves() {
        boolean allTrue = true;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (!predefinedBtns.contains(buttonsArray[i][j]))
                    if (buttonsArray[i][j].getText().equals(solvedBoardBlock[i][j])) {
                        buttonsArray[i][j].setBackground(right);
                        buttonsArray[i][j].setForeground(rightText);
                    } else {
                        allTrue = false;
                        buttonsArray[i][j].setBackground(wrong);
                        buttonsArray[i][j].setForeground(wrongText);
                    }
            }
        }
        if (allTrue) {
            JFrame ResetGameDialog = new JFrame("Reset Game");
            if (JOptionPane.showConfirmDialog(ResetGameDialog,
                    "Yay! You have successfully solved this puzzle. Do You want to reset the game?", "Sudoku Puzzle",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
                unSolvedBoardBlock = copyArray(resetBoardBlock);
                setButtons();
            }
        }
    }

    public Main() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Box1 = new javax.swing.JPanel();
        Box1Btn1 = new javax.swing.JButton();
        Box1Btn2 = new javax.swing.JButton();
        Box1Btn3 = new javax.swing.JButton();
        Box1Btn4 = new javax.swing.JButton();
        Box1Btn5 = new javax.swing.JButton();
        Box1Btn6 = new javax.swing.JButton();
        Box1Btn7 = new javax.swing.JButton();
        Box1Btn8 = new javax.swing.JButton();
        Box1Btn9 = new javax.swing.JButton();
        Box2 = new javax.swing.JPanel();
        Box2Btn1 = new javax.swing.JButton();
        Box2Btn2 = new javax.swing.JButton();
        Box2Btn3 = new javax.swing.JButton();
        Box2Btn4 = new javax.swing.JButton();
        Box2Btn5 = new javax.swing.JButton();
        Box2Btn6 = new javax.swing.JButton();
        Box2Btn7 = new javax.swing.JButton();
        Box2Btn8 = new javax.swing.JButton();
        Box2Btn9 = new javax.swing.JButton();
        Box3 = new javax.swing.JPanel();
        Box3Btn1 = new javax.swing.JButton();
        Box3Btn2 = new javax.swing.JButton();
        Box3Btn3 = new javax.swing.JButton();
        Box3Btn4 = new javax.swing.JButton();
        Box3Btn5 = new javax.swing.JButton();
        Box3Btn6 = new javax.swing.JButton();
        Box3Btn7 = new javax.swing.JButton();
        Box3Btn8 = new javax.swing.JButton();
        Box3Btn9 = new javax.swing.JButton();
        Box4 = new javax.swing.JPanel();
        Box4Btn1 = new javax.swing.JButton();
        Box4Btn2 = new javax.swing.JButton();
        Box4Btn3 = new javax.swing.JButton();
        Box4Btn4 = new javax.swing.JButton();
        Box4Btn5 = new javax.swing.JButton();
        Box4Btn6 = new javax.swing.JButton();
        Box4Btn7 = new javax.swing.JButton();
        Box4Btn8 = new javax.swing.JButton();
        Box4Btn9 = new javax.swing.JButton();
        Box5 = new javax.swing.JPanel();
        Box5Btn1 = new javax.swing.JButton();
        Box5Btn2 = new javax.swing.JButton();
        Box5Btn3 = new javax.swing.JButton();
        Box5Btn4 = new javax.swing.JButton();
        Box5Btn5 = new javax.swing.JButton();
        Box5Btn6 = new javax.swing.JButton();
        Box5Btn7 = new javax.swing.JButton();
        Box5Btn8 = new javax.swing.JButton();
        Box5Btn9 = new javax.swing.JButton();
        Box6 = new javax.swing.JPanel();
        Box6Btn1 = new javax.swing.JButton();
        Box6Btn2 = new javax.swing.JButton();
        Box6Btn3 = new javax.swing.JButton();
        Box6Btn4 = new javax.swing.JButton();
        Box6Btn5 = new javax.swing.JButton();
        Box6Btn6 = new javax.swing.JButton();
        Box6Btn7 = new javax.swing.JButton();
        Box6Btn8 = new javax.swing.JButton();
        Box6Btn9 = new javax.swing.JButton();
        Box7 = new javax.swing.JPanel();
        Box7Btn1 = new javax.swing.JButton();
        Box7Btn2 = new javax.swing.JButton();
        Box7Btn3 = new javax.swing.JButton();
        Box7Btn4 = new javax.swing.JButton();
        Box7Btn5 = new javax.swing.JButton();
        Box7Btn6 = new javax.swing.JButton();
        Box7Btn7 = new javax.swing.JButton();
        Box7Btn8 = new javax.swing.JButton();
        Box7Btn9 = new javax.swing.JButton();
        Box8 = new javax.swing.JPanel();
        Box8Btn1 = new javax.swing.JButton();
        Box8Btn2 = new javax.swing.JButton();
        Box8Btn3 = new javax.swing.JButton();
        Box8Btn4 = new javax.swing.JButton();
        Box8Btn5 = new javax.swing.JButton();
        Box8Btn6 = new javax.swing.JButton();
        Box8Btn7 = new javax.swing.JButton();
        Box8Btn8 = new javax.swing.JButton();
        Box8Btn9 = new javax.swing.JButton();
        Box9 = new javax.swing.JPanel();
        Box9Btn1 = new javax.swing.JButton();
        Box9Btn2 = new javax.swing.JButton();
        Box9Btn3 = new javax.swing.JButton();
        Box9Btn4 = new javax.swing.JButton();
        Box9Btn5 = new javax.swing.JButton();
        Box9Btn6 = new javax.swing.JButton();
        Box9Btn7 = new javax.swing.JButton();
        Box9Btn8 = new javax.swing.JButton();
        Box9Btn9 = new javax.swing.JButton();
        SelectionPanel = new javax.swing.JPanel();
        num1 = new javax.swing.JButton();
        num2 = new javax.swing.JButton();
        num3 = new javax.swing.JButton();
        num4 = new javax.swing.JButton();
        num5 = new javax.swing.JButton();
        num6 = new javax.swing.JButton();
        num7 = new javax.swing.JButton();
        num8 = new javax.swing.JButton();
        num9 = new javax.swing.JButton();
        ExitBtn = new javax.swing.JButton();
        ResetBtn = new javax.swing.JButton();
        SolutionBtn = new javax.swing.JButton();
        CheckBtn = new javax.swing.JButton();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 153));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(474, 540));
        setName("MainFrame"); // NOI18N

        JButton[][] boxArray = {
                { Box1Btn1, Box1Btn2, Box1Btn3, Box1Btn4, Box1Btn5, Box1Btn6, Box1Btn7, Box1Btn8, Box1Btn9 },
                { Box2Btn1, Box2Btn2, Box2Btn3, Box2Btn4, Box2Btn5, Box2Btn6, Box2Btn7, Box2Btn8, Box2Btn9 },
                { Box3Btn1, Box3Btn2, Box3Btn3, Box3Btn4, Box3Btn5, Box3Btn6, Box3Btn7, Box3Btn8, Box3Btn9 },
                { Box4Btn1, Box4Btn2, Box4Btn3, Box4Btn4, Box4Btn5, Box4Btn6, Box4Btn7, Box4Btn8, Box4Btn9 },
                { Box5Btn1, Box5Btn2, Box5Btn3, Box5Btn4, Box5Btn5, Box5Btn6, Box5Btn7, Box5Btn8, Box5Btn9 },
                { Box6Btn1, Box6Btn2, Box6Btn3, Box6Btn4, Box6Btn5, Box6Btn6, Box6Btn7, Box6Btn8, Box6Btn9 },
                { Box7Btn1, Box7Btn2, Box7Btn3, Box7Btn4, Box7Btn5, Box7Btn6, Box7Btn7, Box7Btn8, Box7Btn9 },
                { Box8Btn1, Box8Btn2, Box8Btn3, Box8Btn4, Box8Btn5, Box8Btn6, Box8Btn7, Box8Btn8, Box8Btn9 },
                { Box9Btn1, Box9Btn2, Box9Btn3, Box9Btn4, Box9Btn5, Box9Btn6, Box9Btn7, Box9Btn8, Box9Btn9 }
        };
        buttonsArray = boxArray;
        setButtons();

        Box1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        Box1Btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box1Btn1ActionPerformed(evt);
            }
        });

        Box1Btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box1Btn2ActionPerformed(evt);
            }
        });

        Box1Btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box1Btn3ActionPerformed(evt);
            }
        });

        Box1Btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box1Btn4ActionPerformed(evt);
            }
        });

        Box1Btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box1Btn5ActionPerformed(evt);
            }
        });

        Box1Btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box1Btn6ActionPerformed(evt);
            }
        });

        Box1Btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box1Btn7ActionPerformed(evt);
            }
        });

        Box1Btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box1Btn8ActionPerformed(evt);
            }
        });

        Box1Btn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box1Btn9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Box1Layout = new javax.swing.GroupLayout(Box1);
        Box1.setLayout(Box1Layout);
        Box1Layout.setHorizontalGroup(
                Box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(Box1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(Box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(Box1Layout.createSequentialGroup()
                                                .addComponent(Box1Btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Box1Btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Box1Btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(Box1Layout.createSequentialGroup()
                                                .addComponent(Box1Btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Box1Btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Box1Btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(Box1Layout.createSequentialGroup()
                                                .addComponent(Box1Btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Box1Btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Box1Btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        Box1Layout.setVerticalGroup(
                Box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(Box1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(Box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Box1Btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Box1Btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Box1Btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(Box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Box1Btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Box1Btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Box1Btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(Box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Box1Btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Box1Btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Box1Btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        Box2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        Box2Btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box2Btn1ActionPerformed(evt);
            }
        });

        Box2Btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box2Btn2ActionPerformed(evt);
            }
        });

        Box2Btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box2Btn3ActionPerformed(evt);
            }
        });

        Box2Btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box2Btn4ActionPerformed(evt);
            }
        });

        Box2Btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box2Btn5ActionPerformed(evt);
            }
        });

        Box2Btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box2Btn6ActionPerformed(evt);
            }
        });

        Box2Btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box2Btn7ActionPerformed(evt);
            }
        });

        Box2Btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box2Btn8ActionPerformed(evt);
            }
        });

        Box2Btn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box2Btn9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Box2Layout = new javax.swing.GroupLayout(Box2);
        Box2.setLayout(Box2Layout);
        Box2Layout.setHorizontalGroup(
                Box2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(Box2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(Box2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(Box2Layout.createSequentialGroup()
                                                .addComponent(Box2Btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Box2Btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Box2Btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(Box2Layout.createSequentialGroup()
                                                .addComponent(Box2Btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Box2Btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Box2Btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(Box2Layout.createSequentialGroup()
                                                .addComponent(Box2Btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Box2Btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Box2Btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        Box2Layout.setVerticalGroup(
                Box2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(Box2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(Box2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Box2Btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Box2Btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Box2Btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(Box2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Box2Btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Box2Btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Box2Btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(Box2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Box2Btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Box2Btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Box2Btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        Box3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        Box3Btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box3Btn1ActionPerformed(evt);
            }
        });

        Box3Btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box3Btn2ActionPerformed(evt);
            }
        });

        Box3Btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box3Btn3ActionPerformed(evt);
            }
        });

        Box3Btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box3Btn4ActionPerformed(evt);
            }
        });

        Box3Btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box3Btn5ActionPerformed(evt);
            }
        });

        Box3Btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box3Btn6ActionPerformed(evt);
            }
        });

        Box3Btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box3Btn7ActionPerformed(evt);
            }
        });

        Box3Btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box3Btn8ActionPerformed(evt);
            }
        });

        Box3Btn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box3Btn9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Box3Layout = new javax.swing.GroupLayout(Box3);
        Box3.setLayout(Box3Layout);
        Box3Layout.setHorizontalGroup(
                Box3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(Box3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(Box3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(Box3Layout.createSequentialGroup()
                                                .addComponent(Box3Btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Box3Btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Box3Btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(Box3Layout.createSequentialGroup()
                                                .addComponent(Box3Btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Box3Btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Box3Btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(Box3Layout.createSequentialGroup()
                                                .addComponent(Box3Btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Box3Btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Box3Btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        Box3Layout.setVerticalGroup(
                Box3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(Box3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(Box3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Box3Btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Box3Btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Box3Btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(Box3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Box3Btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Box3Btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Box3Btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(Box3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Box3Btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Box3Btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Box3Btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        Box4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        Box4Btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box4Btn1ActionPerformed(evt);
            }
        });

        Box4Btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box4Btn2ActionPerformed(evt);
            }
        });

        Box4Btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box4Btn3ActionPerformed(evt);
            }
        });

        Box4Btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box4Btn4ActionPerformed(evt);
            }
        });

        Box4Btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box4Btn5ActionPerformed(evt);
            }
        });

        Box4Btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box4Btn6ActionPerformed(evt);
            }
        });

        Box4Btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box4Btn7ActionPerformed(evt);
            }
        });

        Box4Btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box4Btn8ActionPerformed(evt);
            }
        });

        Box4Btn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box4Btn9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Box4Layout = new javax.swing.GroupLayout(Box4);
        Box4.setLayout(Box4Layout);
        Box4Layout.setHorizontalGroup(
                Box4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(Box4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(Box4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(Box4Layout.createSequentialGroup()
                                                .addComponent(Box4Btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Box4Btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Box4Btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(Box4Layout.createSequentialGroup()
                                                .addComponent(Box4Btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Box4Btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Box4Btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(Box4Layout.createSequentialGroup()
                                                .addComponent(Box4Btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Box4Btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Box4Btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        Box4Layout.setVerticalGroup(
                Box4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(Box4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(Box4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Box4Btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Box4Btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Box4Btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(Box4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Box4Btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Box4Btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Box4Btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(Box4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Box4Btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Box4Btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Box4Btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        Box5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        Box5Btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box5Btn1ActionPerformed(evt);
            }
        });

        Box5Btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box5Btn2ActionPerformed(evt);
            }
        });

        Box5Btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box5Btn3ActionPerformed(evt);
            }
        });

        Box5Btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box5Btn4ActionPerformed(evt);
            }
        });

        Box5Btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box5Btn5ActionPerformed(evt);
            }
        });

        Box5Btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box5Btn6ActionPerformed(evt);
            }
        });

        Box5Btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box5Btn7ActionPerformed(evt);
            }
        });

        Box5Btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box5Btn8ActionPerformed(evt);
            }
        });

        Box5Btn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box5Btn9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Box5Layout = new javax.swing.GroupLayout(Box5);
        Box5.setLayout(Box5Layout);
        Box5Layout.setHorizontalGroup(
                Box5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(Box5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(Box5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(Box5Layout.createSequentialGroup()
                                                .addComponent(Box5Btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Box5Btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Box5Btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(Box5Layout.createSequentialGroup()
                                                .addComponent(Box5Btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Box5Btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Box5Btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(Box5Layout.createSequentialGroup()
                                                .addComponent(Box5Btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Box5Btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Box5Btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        Box5Layout.setVerticalGroup(
                Box5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(Box5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(Box5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Box5Btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Box5Btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Box5Btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(Box5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Box5Btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Box5Btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Box5Btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(Box5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Box5Btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Box5Btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Box5Btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        Box6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        Box6Btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box6Btn1ActionPerformed(evt);
            }
        });

        Box6Btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box6Btn2ActionPerformed(evt);
            }
        });

        Box6Btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box6Btn3ActionPerformed(evt);
            }
        });

        Box6Btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box6Btn4ActionPerformed(evt);
            }
        });

        Box6Btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box6Btn5ActionPerformed(evt);
            }
        });

        Box6Btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box6Btn6ActionPerformed(evt);
            }
        });

        Box6Btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box6Btn7ActionPerformed(evt);
            }
        });

        Box6Btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box6Btn8ActionPerformed(evt);
            }
        });

        Box6Btn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box6Btn9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Box6Layout = new javax.swing.GroupLayout(Box6);
        Box6.setLayout(Box6Layout);
        Box6Layout.setHorizontalGroup(
                Box6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(Box6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(Box6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(Box6Layout.createSequentialGroup()
                                                .addComponent(Box6Btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Box6Btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Box6Btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(Box6Layout.createSequentialGroup()
                                                .addComponent(Box6Btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Box6Btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Box6Btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(Box6Layout.createSequentialGroup()
                                                .addComponent(Box6Btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Box6Btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Box6Btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        Box6Layout.setVerticalGroup(
                Box6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(Box6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(Box6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Box6Btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Box6Btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Box6Btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(Box6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Box6Btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Box6Btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Box6Btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(Box6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Box6Btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Box6Btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Box6Btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        Box7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        Box7Btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box7Btn1ActionPerformed(evt);
            }
        });

        Box7Btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box7Btn2ActionPerformed(evt);
            }
        });

        Box7Btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box7Btn3ActionPerformed(evt);
            }
        });

        Box7Btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box7Btn4ActionPerformed(evt);
            }
        });

        Box7Btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box7Btn5ActionPerformed(evt);
            }
        });

        Box7Btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box7Btn6ActionPerformed(evt);
            }
        });

        Box7Btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box7Btn7ActionPerformed(evt);
            }
        });

        Box7Btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box7Btn8ActionPerformed(evt);
            }
        });

        Box7Btn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box7Btn9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Box7Layout = new javax.swing.GroupLayout(Box7);
        Box7.setLayout(Box7Layout);
        Box7Layout.setHorizontalGroup(
                Box7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(Box7Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(Box7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(Box7Layout.createSequentialGroup()
                                                .addComponent(Box7Btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Box7Btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Box7Btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(Box7Layout.createSequentialGroup()
                                                .addComponent(Box7Btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Box7Btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Box7Btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(Box7Layout.createSequentialGroup()
                                                .addComponent(Box7Btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Box7Btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Box7Btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        Box7Layout.setVerticalGroup(
                Box7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(Box7Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(Box7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Box7Btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Box7Btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Box7Btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(Box7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Box7Btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Box7Btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Box7Btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(Box7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Box7Btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Box7Btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Box7Btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        Box8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        Box8Btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box8Btn1ActionPerformed(evt);
            }
        });

        Box8Btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box8Btn2ActionPerformed(evt);
            }
        });

        Box8Btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box8Btn3ActionPerformed(evt);
            }
        });

        Box8Btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box8Btn4ActionPerformed(evt);
            }
        });

        Box8Btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box8Btn5ActionPerformed(evt);
            }
        });

        Box8Btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box8Btn6ActionPerformed(evt);
            }
        });

        Box8Btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box8Btn7ActionPerformed(evt);
            }
        });

        Box8Btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box8Btn8ActionPerformed(evt);
            }
        });

        Box8Btn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box8Btn9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Box8Layout = new javax.swing.GroupLayout(Box8);
        Box8.setLayout(Box8Layout);
        Box8Layout.setHorizontalGroup(
                Box8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(Box8Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(Box8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(Box8Layout.createSequentialGroup()
                                                .addComponent(Box8Btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Box8Btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Box8Btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(Box8Layout.createSequentialGroup()
                                                .addComponent(Box8Btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Box8Btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Box8Btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(Box8Layout.createSequentialGroup()
                                                .addComponent(Box8Btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Box8Btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Box8Btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        Box8Layout.setVerticalGroup(
                Box8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(Box8Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(Box8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Box8Btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Box8Btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Box8Btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(Box8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Box8Btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Box8Btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Box8Btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(Box8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Box8Btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Box8Btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Box8Btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        Box9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        Box9Btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box9Btn1ActionPerformed(evt);
            }
        });

        Box9Btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box9Btn2ActionPerformed(evt);
            }
        });

        Box9Btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box9Btn3ActionPerformed(evt);
            }
        });

        Box9Btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box9Btn4ActionPerformed(evt);
            }
        });

        Box9Btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box9Btn5ActionPerformed(evt);
            }
        });

        Box9Btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box9Btn6ActionPerformed(evt);
            }
        });

        Box9Btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box9Btn7ActionPerformed(evt);
            }
        });

        Box9Btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box9Btn8ActionPerformed(evt);
            }
        });

        Box9Btn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box9Btn9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Box9Layout = new javax.swing.GroupLayout(Box9);
        Box9.setLayout(Box9Layout);
        Box9Layout.setHorizontalGroup(
                Box9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(Box9Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(Box9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(Box9Layout.createSequentialGroup()
                                                .addComponent(Box9Btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Box9Btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Box9Btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(Box9Layout.createSequentialGroup()
                                                .addComponent(Box9Btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Box9Btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Box9Btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(Box9Layout.createSequentialGroup()
                                                .addComponent(Box9Btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Box9Btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Box9Btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        Box9Layout.setVerticalGroup(
                Box9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(Box9Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(Box9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Box9Btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Box9Btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Box9Btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(Box9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Box9Btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Box9Btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Box9Btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(Box9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Box9Btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Box9Btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Box9Btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        SelectionPanel.setBackground(new java.awt.Color(255, 255, 255));
        SelectionPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED,
                java.awt.Color.lightGray, java.awt.Color.white));

        num1.setBackground(numSelected);
        num1.setFont(new java.awt.Font("Fira Code SemiBold", 1, 12)); // NOI18N
        num1.setForeground(numSelectedText);
        num1.setText("1");
        num1.setBorder(null);
        num1.setMinimumSize(new java.awt.Dimension(40, 40));
        num1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num1ActionPerformed(evt);
            }
        });
        num2.setBackground(numUnselected);
        num2.setFont(new java.awt.Font("Fira Code SemiBold", 1, 12)); // NOI18N
        num2.setForeground(numUnselectedText);
        num2.setText("2");
        num2.setBorder(null);
        num2.setMinimumSize(new java.awt.Dimension(40, 40));
        num2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num2ActionPerformed(evt);
            }
        });
        num3.setBackground(numUnselected);
        num3.setFont(new java.awt.Font("Fira Code SemiBold", 1, 12)); // NOI18N
        num3.setForeground(numUnselectedText);
        num3.setText("3");
        num3.setBorder(null);
        num3.setMinimumSize(new java.awt.Dimension(40, 40));
        num3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num3ActionPerformed(evt);
            }
        });

        num4.setBackground(numUnselected);
        num4.setFont(new java.awt.Font("Fira Code SemiBold", 1, 12)); // NOI18N
        num4.setForeground(numUnselectedText);
        num4.setText("4");
        num4.setBorder(null);
        num4.setMinimumSize(new java.awt.Dimension(40, 40));
        num4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num4ActionPerformed(evt);
            }
        });
        num5.setBackground(numUnselected);
        num5.setFont(new java.awt.Font("Fira Code SemiBold", 1, 12)); // NOI18N
        num5.setForeground(numUnselectedText);
        num5.setText("5");
        num5.setBorder(null);
        num5.setMinimumSize(new java.awt.Dimension(40, 40));
        num5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num5ActionPerformed(evt);
            }
        });
        num6.setBackground(numUnselected);
        num6.setFont(new java.awt.Font("Fira Code SemiBold", 1, 12)); // NOI18N
        num6.setForeground(numUnselectedText);
        num6.setText("6");
        num6.setBorder(null);
        num6.setMinimumSize(new java.awt.Dimension(40, 40));
        num6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num6ActionPerformed(evt);
            }
        });

        num7.setBackground(numUnselected);
        num7.setFont(new java.awt.Font("Fira Code SemiBold", 1, 12)); // NOI18N
        num7.setForeground(numUnselectedText);
        num7.setText("7");
        num7.setBorder(null);
        num7.setMinimumSize(new java.awt.Dimension(40, 40));
        num7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num7ActionPerformed(evt);
            }
        });
        num8.setBackground(numUnselected);
        num8.setFont(new java.awt.Font("Fira Code SemiBold", 1, 12)); // NOI18N
        num8.setForeground(numUnselectedText);
        num8.setText("8");
        num8.setBorder(null);
        num8.setMinimumSize(new java.awt.Dimension(40, 40));
        num8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num8ActionPerformed(evt);
            }
        });

        num9.setBackground(numUnselected);
        num9.setFont(new java.awt.Font("Fira Code SemiBold", 1, 12)); // NOI18N
        num9.setForeground(numUnselectedText);
        num9.setText("9");
        num9.setBorder(null);
        num9.setMinimumSize(new java.awt.Dimension(40, 40));
        num9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num9ActionPerformed(evt);
            }
        });
        javax.swing.GroupLayout SelectionPanelLayout = new javax.swing.GroupLayout(SelectionPanel);
        SelectionPanel.setLayout(SelectionPanelLayout);
        SelectionPanelLayout.setHorizontalGroup(
                SelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(SelectionPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(num1, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(num2, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(num3, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(num4, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(num5, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(num6, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(num7, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(num8, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(num9, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        SelectionPanelLayout.setVerticalGroup(
                SelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(SelectionPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(SelectionPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(num1, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(num2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(num3, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(num4, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(num5, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(num6, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(num7, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(num8, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(num9, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap()));

        ExitBtn.setBackground(new java.awt.Color(75, 195, 241));
        ExitBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ExitBtn.setForeground(new java.awt.Color(255, 255, 255));
        ExitBtn.setText("Exit");
        ExitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitBtnActionPerformed(evt);
            }
        });
        ResetBtn.setBackground(new java.awt.Color(255, 0, 0));
        ResetBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ResetBtn.setForeground(new java.awt.Color(255, 255, 255));
        ResetBtn.setText("Reset");
        ResetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetBtnActionPerformed(evt);
            }
        });

        SolutionBtn.setBackground(new java.awt.Color(117, 255, 0));
        SolutionBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        SolutionBtn.setForeground(new java.awt.Color(255, 255, 255));
        SolutionBtn.setText("Solution");
        SolutionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SolutionBtnActionPerformed(evt);
            }
        });
        CheckBtn.setBackground(new java.awt.Color(255, 167, 0));
        CheckBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CheckBtn.setForeground(new java.awt.Color(255, 255, 255));
        CheckBtn.setText("Check Moves");
        CheckBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckBtnActionPerformed(evt);
            }
        });
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(Box1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(Box2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(Box3, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(Box4, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(Box5, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(Box6, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(Box7, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(Box8, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(Box9, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(ExitBtn)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(ResetBtn)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(SolutionBtn,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 99,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(CheckBtn,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE))
                                                        .addComponent(SelectionPanel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Box3, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Box2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Box1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Box6, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Box5, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Box4, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Box9, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Box8, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Box7, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(SelectionPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(SolutionBtn, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(ExitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(ResetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(CheckBtn, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap()));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Box1Btn1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box1Btn1ActionPerformed
        performAction(Box1Btn1, 0, 0);
    }// GEN-LAST:event_Box1Btn1ActionPerformed

    private void Box1Btn2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box1Btn2ActionPerformed
        performAction(Box1Btn2, 0, 1);
    }// GEN-LAST:event_Box1Btn2ActionPerformed

    private void Box1Btn3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box1Btn3ActionPerformed
        performAction(Box1Btn3, 0, 2);
    }// GEN-LAST:event_Box1Btn3ActionPerformed

    private void Box1Btn4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box1Btn4ActionPerformed
        performAction(Box1Btn4, 0, 3);
    }// GEN-LAST:event_Box1Btn4ActionPerformed

    private void Box1Btn5ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box1Btn5ActionPerformed
        performAction(Box1Btn5, 0, 4);
    }// GEN-LAST:event_Box1Btn5ActionPerformed

    private void Box1Btn6ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box1Btn6ActionPerformed
        performAction(Box1Btn6, 0, 5);
    }// GEN-LAST:event_Box1Btn6ActionPerformed

    private void Box1Btn7ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box1Btn7ActionPerformed
        performAction(Box1Btn7, 0, 6);
    }// GEN-LAST:event_Box1Btn7ActionPerformed

    private void Box1Btn8ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box1Btn8ActionPerformed
        performAction(Box1Btn8, 0, 7);
    }// GEN-LAST:event_Box1Btn8ActionPerformed

    private void Box1Btn9ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box1Btn9ActionPerformed
        performAction(Box1Btn9, 0, 8);
    }// GEN-LAST:event_Box1Btn9ActionPerformed

    private void Box2Btn1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box2Btn1ActionPerformed
        performAction(Box2Btn1, 1, 0);
    }// GEN-LAST:event_Box2Btn1ActionPerformed

    private void Box2Btn2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box2Btn2ActionPerformed
        performAction(Box2Btn2, 1, 1);
    }// GEN-LAST:event_Box2Btn2ActionPerformed

    private void Box2Btn3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box2Btn3ActionPerformed
        performAction(Box2Btn3, 1, 2);
    }// GEN-LAST:event_Box2Btn3ActionPerformed

    private void Box2Btn4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box2Btn4ActionPerformed
        performAction(Box2Btn4, 1, 3);
    }// GEN-LAST:event_Box2Btn4ActionPerformed

    private void Box2Btn5ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box2Btn5ActionPerformed
        performAction(Box2Btn5, 1, 4);
    }// GEN-LAST:event_Box2Btn5ActionPerformed

    private void Box2Btn6ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box2Btn6ActionPerformed
        performAction(Box2Btn6, 1, 5);
    }// GEN-LAST:event_Box2Btn6ActionPerformed

    private void Box2Btn7ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box2Btn7ActionPerformed
        performAction(Box2Btn7, 1, 6);
    }// GEN-LAST:event_Box2Btn7ActionPerformed

    private void Box2Btn8ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box2Btn8ActionPerformed
        performAction(Box2Btn8, 1, 7);
    }// GEN-LAST:event_Box2Btn8ActionPerformed

    private void Box2Btn9ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box2Btn9ActionPerformed
        performAction(Box2Btn9, 1, 8);
    }// GEN-LAST:event_Box2Btn9ActionPerformed

    private void Box3Btn1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box3Btn1ActionPerformed
        performAction(Box3Btn1, 2, 0);
    }// GEN-LAST:event_Box3Btn1ActionPerformed

    private void Box3Btn2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box3Btn2ActionPerformed
        performAction(Box3Btn2, 2, 1);
    }// GEN-LAST:event_Box3Btn2ActionPerformed

    private void Box3Btn3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box3Btn3ActionPerformed
        performAction(Box3Btn3, 2, 2);
    }// GEN-LAST:event_Box3Btn3ActionPerformed

    private void Box3Btn4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box3Btn4ActionPerformed
        performAction(Box3Btn4, 2, 3);
    }// GEN-LAST:event_Box3Btn4ActionPerformed

    private void Box3Btn5ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box3Btn5ActionPerformed
        performAction(Box3Btn5, 2, 4);
    }// GEN-LAST:event_Box3Btn5ActionPerformed

    private void Box3Btn6ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box3Btn6ActionPerformed
        performAction(Box3Btn6, 2, 5);
    }// GEN-LAST:event_Box3Btn6ActionPerformed

    private void Box3Btn7ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box3Btn7ActionPerformed
        performAction(Box3Btn7, 2, 6);
    }// GEN-LAST:event_Box3Btn7ActionPerformed

    private void Box3Btn8ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box3Btn8ActionPerformed
        performAction(Box3Btn8, 2, 7);
    }// GEN-LAST:event_Box3Btn8ActionPerformed

    private void Box3Btn9ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box3Btn9ActionPerformed
        performAction(Box3Btn9, 2, 8);
    }// GEN-LAST:event_Box3Btn9ActionPerformed

    private void Box4Btn1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box4Btn1ActionPerformed
        performAction(Box4Btn1, 3, 0);
    }// GEN-LAST:event_Box4Btn1ActionPerformed

    private void Box4Btn2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box4Btn2ActionPerformed
        performAction(Box4Btn2, 3, 1);
    }// GEN-LAST:event_Box4Btn2ActionPerformed

    private void Box4Btn3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box4Btn3ActionPerformed
        performAction(Box4Btn3, 3, 2);
    }// GEN-LAST:event_Box4Btn3ActionPerformed

    private void Box4Btn4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box4Btn4ActionPerformed
        performAction(Box4Btn4, 3, 3);
    }// GEN-LAST:event_Box4Btn4ActionPerformed

    private void Box4Btn5ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box4Btn5ActionPerformed
        performAction(Box4Btn5, 3, 4);
    }// GEN-LAST:event_Box4Btn5ActionPerformed

    private void Box4Btn6ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box4Btn6ActionPerformed
        performAction(Box4Btn6, 3, 5);
    }// GEN-LAST:event_Box4Btn6ActionPerformed

    private void Box4Btn7ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box4Btn7ActionPerformed
        performAction(Box4Btn7, 3, 6);
    }// GEN-LAST:event_Box4Btn7ActionPerformed

    private void Box4Btn8ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box4Btn8ActionPerformed
        performAction(Box4Btn8, 3, 7);
    }// GEN-LAST:event_Box4Btn8ActionPerformed

    private void Box4Btn9ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box4Btn9ActionPerformed
        performAction(Box4Btn9, 3, 8);
    }// GEN-LAST:event_Box4Btn9ActionPerformed

    private void Box5Btn1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box5Btn1ActionPerformed
        performAction(Box5Btn1, 4, 0);
    }// GEN-LAST:event_Box5Btn1ActionPerformed

    private void Box5Btn2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box5Btn2ActionPerformed
        performAction(Box5Btn2, 4, 1);
    }// GEN-LAST:event_Box5Btn2ActionPerformed

    private void Box5Btn3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box5Btn3ActionPerformed
        performAction(Box5Btn3, 4, 2);
    }// GEN-LAST:event_Box5Btn3ActionPerformed

    private void Box5Btn4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box5Btn4ActionPerformed
        performAction(Box5Btn4, 4, 3);
    }// GEN-LAST:event_Box5Btn4ActionPerformed

    private void Box5Btn5ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box5Btn5ActionPerformed
        performAction(Box5Btn5, 4, 4);
    }// GEN-LAST:event_Box5Btn5ActionPerformed

    private void Box5Btn6ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box5Btn6ActionPerformed
        performAction(Box5Btn6, 4, 5);
    }// GEN-LAST:event_Box5Btn6ActionPerformed

    private void Box5Btn7ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box5Btn7ActionPerformed
        performAction(Box5Btn7, 4, 6);
    }// GEN-LAST:event_Box5Btn7ActionPerformed

    private void Box5Btn8ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box5Btn8ActionPerformed
        performAction(Box5Btn8, 4, 7);
    }// GEN-LAST:event_Box5Btn8ActionPerformed

    private void Box5Btn9ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box5Btn9ActionPerformed
        performAction(Box5Btn9, 4, 8);
    }// GEN-LAST:event_Box5Btn9ActionPerformed

    private void Box6Btn1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box6Btn1ActionPerformed
        performAction(Box6Btn1, 5, 0);
    }// GEN-LAST:event_Box6Btn1ActionPerformed

    private void Box6Btn2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box6Btn2ActionPerformed
        performAction(Box6Btn2, 5, 1);
    }// GEN-LAST:event_Box6Btn2ActionPerformed

    private void Box6Btn3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box6Btn3ActionPerformed
        performAction(Box6Btn3, 5, 2);
    }// GEN-LAST:event_Box6Btn3ActionPerformed

    private void Box6Btn4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box6Btn4ActionPerformed
        performAction(Box6Btn4, 5, 3);
    }// GEN-LAST:event_Box6Btn4ActionPerformed

    private void Box6Btn5ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box6Btn5ActionPerformed
        performAction(Box6Btn5, 5, 4);
    }// GEN-LAST:event_Box6Btn5ActionPerformed

    private void Box6Btn6ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box6Btn6ActionPerformed
        performAction(Box6Btn6, 5, 5);
    }// GEN-LAST:event_Box6Btn6ActionPerformed

    private void Box6Btn7ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box6Btn7ActionPerformed
        performAction(Box6Btn7, 5, 6);
    }// GEN-LAST:event_Box6Btn7ActionPerformed

    private void Box6Btn8ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box6Btn8ActionPerformed
        performAction(Box6Btn8, 5, 7);
    }// GEN-LAST:event_Box6Btn8ActionPerformed

    private void Box6Btn9ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box6Btn9ActionPerformed
        performAction(Box6Btn9, 5, 8);
    }// GEN-LAST:event_Box6Btn9ActionPerformed

    private void Box7Btn1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box7Btn1ActionPerformed
        performAction(Box7Btn1, 6, 0);
    }// GEN-LAST:event_Box7Btn1ActionPerformed

    private void Box7Btn2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box7Btn2ActionPerformed
        performAction(Box7Btn2, 6, 1);
    }// GEN-LAST:event_Box7Btn2ActionPerformed

    private void Box7Btn3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box7Btn3ActionPerformed
        performAction(Box7Btn3, 6, 2);
    }// GEN-LAST:event_Box7Btn3ActionPerformed

    private void Box7Btn4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box7Btn4ActionPerformed
        performAction(Box7Btn4, 6, 3);
    }// GEN-LAST:event_Box7Btn4ActionPerformed

    private void Box7Btn5ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box7Btn5ActionPerformed
        performAction(Box7Btn5, 6, 4);
    }// GEN-LAST:event_Box7Btn5ActionPerformed

    private void Box7Btn6ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box7Btn6ActionPerformed
        performAction(Box7Btn6, 6, 5);
    }// GEN-LAST:event_Box7Btn6ActionPerformed

    private void Box7Btn7ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box7Btn7ActionPerformed
        performAction(Box7Btn7, 6, 6);
    }// GEN-LAST:event_Box7Btn7ActionPerformed

    private void Box7Btn8ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box7Btn8ActionPerformed
        performAction(Box7Btn8, 6, 7);
    }// GEN-LAST:event_Box7Btn8ActionPerformed

    private void Box7Btn9ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box7Btn9ActionPerformed
        performAction(Box7Btn9, 6, 8);
    }// GEN-LAST:event_Box7Btn9ActionPerformed

    private void Box8Btn1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box8Btn1ActionPerformed
        performAction(Box8Btn1, 7, 0);
    }// GEN-LAST:event_Box8Btn1ActionPerformed

    private void Box8Btn2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box8Btn2ActionPerformed
        performAction(Box8Btn2, 7, 1);
    }// GEN-LAST:event_Box8Btn2ActionPerformed

    private void Box8Btn3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box8Btn3ActionPerformed
        performAction(Box8Btn3, 7, 2);
    }// GEN-LAST:event_Box8Btn3ActionPerformed

    private void Box8Btn4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box8Btn4ActionPerformed
        performAction(Box8Btn4, 7, 3);
    }// GEN-LAST:event_Box8Btn4ActionPerformed

    private void Box8Btn5ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box8Btn5ActionPerformed
        performAction(Box8Btn5, 7, 4);
    }// GEN-LAST:event_Box8Btn5ActionPerformed

    private void Box8Btn6ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box8Btn6ActionPerformed
        performAction(Box8Btn6, 7, 5);
    }// GEN-LAST:event_Box8Btn6ActionPerformed

    private void Box8Btn7ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box8Btn7ActionPerformed
        performAction(Box8Btn7, 7, 6);
    }// GEN-LAST:event_Box8Btn7ActionPerformed

    private void Box8Btn8ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box8Btn8ActionPerformed
        performAction(Box8Btn8, 7, 7);
    }// GEN-LAST:event_Box8Btn8ActionPerformed

    private void Box8Btn9ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box8Btn9ActionPerformed
        performAction(Box8Btn9, 7, 8);
    }// GEN-LAST:event_Box8Btn9ActionPerformed

    private void Box9Btn1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box9Btn1ActionPerformed
        performAction(Box9Btn1, 8, 0);
    }// GEN-LAST:event_Box9Btn1ActionPerformed

    private void Box9Btn2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box9Btn2ActionPerformed
        performAction(Box9Btn2, 8, 1);
    }// GEN-LAST:event_Box9Btn2ActionPerformed

    private void Box9Btn3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box9Btn3ActionPerformed
        performAction(Box9Btn3, 8, 2);
    }// GEN-LAST:event_Box9Btn3ActionPerformed

    private void Box9Btn4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box9Btn4ActionPerformed
        performAction(Box9Btn4, 8, 3);
    }// GEN-LAST:event_Box9Btn4ActionPerformed

    private void Box9Btn5ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box9Btn5ActionPerformed
        performAction(Box9Btn5, 8, 4);
    }// GEN-LAST:event_Box9Btn5ActionPerformed

    private void Box9Btn6ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box9Btn6ActionPerformed
        performAction(Box9Btn6, 8, 5);
    }// GEN-LAST:event_Box9Btn6ActionPerformed

    private void Box9Btn7ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box9Btn7ActionPerformed
        performAction(Box9Btn7, 8, 6);
    }// GEN-LAST:event_Box9Btn7ActionPerformed

    private void Box9Btn8ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box9Btn8ActionPerformed
        performAction(Box9Btn8, 8, 7);
    }// GEN-LAST:event_Box9Btn8ActionPerformed

    private void Box9Btn9ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Box9Btn9ActionPerformed
        performAction(Box9Btn9, 8, 8);
    }// GEN-LAST:event_Box9Btn9ActionPerformed

    private void num1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_num3ActionPerformed
        changeSelected("1");
    }// GEN-LAST:event_num3ActionPerformed

    private void num2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_num3ActionPerformed
        changeSelected("2");
    }// GEN-LAST:event_num3ActionPerformed

    private void num3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_num3ActionPerformed
        changeSelected("3");
    }// GEN-LAST:event_num3ActionPerformed

    private void num4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_num3ActionPerformed
        changeSelected("4");
    }// GEN-LAST:event_num3ActionPerformed

    private void num5ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_num3ActionPerformed
        changeSelected("5");
    }// GEN-LAST:event_num3ActionPerformed

    private void num6ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_num6ActionPerformed
        changeSelected("6");
    }// GEN-LAST:event_num6ActionPerformed

    private void num7ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_num3ActionPerformed
        changeSelected("7");
    }// GEN-LAST:event_num3ActionPerformed

    private void num8ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_num8ActionPerformed
        changeSelected("8");
    }// GEN-LAST:event_num8ActionPerformed

    private void num9ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_num3ActionPerformed
        changeSelected("9");
    }// GEN-LAST:event_num3ActionPerformed

    private void ExitBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_ExitBtnActionPerformed
        JFrame ExitGameDialog = new JFrame("Exit Game");
        if (JOptionPane.showConfirmDialog(ExitGameDialog, "Confirm if you want to exit the game!", "Sudoku Puzzle",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION)
            System.exit(0);
    }// GEN-LAST:event_ExitBtnActionPerformed

    private void ResetBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_ResetBtnActionPerformed
        JFrame ResetGameDialog = new JFrame("Reset Game");
        if (JOptionPane.showConfirmDialog(ResetGameDialog, "Confirm if you want to reset the game!", "Sudoku Puzzle",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
            unSolvedBoardBlock = copyArray(resetBoardBlock);
            setButtons();
        }
    }// GEN-LAST:event_ResetBtnActionPerformed

    private void SolutionBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_SolutionBtnActionPerformed
        seeSolution = !seeSolution;
        toggleSolution();
    }// GEN-LAST:event_SolutionBtnActionPerformed

    private void CheckBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_CheckBtnActionPerformed
        checkMoves();
    }// GEN-LAST:event_CheckBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Box1;
    private javax.swing.JButton Box1Btn1;
    private javax.swing.JButton Box1Btn2;
    private javax.swing.JButton Box1Btn3;
    private javax.swing.JButton Box1Btn4;
    private javax.swing.JButton Box1Btn5;
    private javax.swing.JButton Box1Btn6;
    private javax.swing.JButton Box1Btn7;
    private javax.swing.JButton Box1Btn8;
    private javax.swing.JButton Box1Btn9;
    private javax.swing.JPanel Box2;
    private javax.swing.JButton Box2Btn1;
    private javax.swing.JButton Box2Btn2;
    private javax.swing.JButton Box2Btn3;
    private javax.swing.JButton Box2Btn4;
    private javax.swing.JButton Box2Btn5;
    private javax.swing.JButton Box2Btn6;
    private javax.swing.JButton Box2Btn7;
    private javax.swing.JButton Box2Btn8;
    private javax.swing.JButton Box2Btn9;
    private javax.swing.JPanel Box3;
    private javax.swing.JButton Box3Btn1;
    private javax.swing.JButton Box3Btn2;
    private javax.swing.JButton Box3Btn3;
    private javax.swing.JButton Box3Btn4;
    private javax.swing.JButton Box3Btn5;
    private javax.swing.JButton Box3Btn6;
    private javax.swing.JButton Box3Btn7;
    private javax.swing.JButton Box3Btn8;
    private javax.swing.JButton Box3Btn9;
    private javax.swing.JPanel Box4;
    private javax.swing.JButton Box4Btn1;
    private javax.swing.JButton Box4Btn2;
    private javax.swing.JButton Box4Btn3;
    private javax.swing.JButton Box4Btn4;
    private javax.swing.JButton Box4Btn5;
    private javax.swing.JButton Box4Btn6;
    private javax.swing.JButton Box4Btn7;
    private javax.swing.JButton Box4Btn8;
    private javax.swing.JButton Box4Btn9;
    private javax.swing.JPanel Box5;
    private javax.swing.JButton Box5Btn1;
    private javax.swing.JButton Box5Btn2;
    private javax.swing.JButton Box5Btn3;
    private javax.swing.JButton Box5Btn4;
    private javax.swing.JButton Box5Btn5;
    private javax.swing.JButton Box5Btn6;
    private javax.swing.JButton Box5Btn7;
    private javax.swing.JButton Box5Btn8;
    private javax.swing.JButton Box5Btn9;
    private javax.swing.JPanel Box6;
    private javax.swing.JButton Box6Btn1;
    private javax.swing.JButton Box6Btn2;
    private javax.swing.JButton Box6Btn3;
    private javax.swing.JButton Box6Btn4;
    private javax.swing.JButton Box6Btn5;
    private javax.swing.JButton Box6Btn6;
    private javax.swing.JButton Box6Btn7;
    private javax.swing.JButton Box6Btn8;
    private javax.swing.JButton Box6Btn9;
    private javax.swing.JPanel Box7;
    private javax.swing.JButton Box7Btn1;
    private javax.swing.JButton Box7Btn2;
    private javax.swing.JButton Box7Btn3;
    private javax.swing.JButton Box7Btn4;
    private javax.swing.JButton Box7Btn5;
    private javax.swing.JButton Box7Btn6;
    private javax.swing.JButton Box7Btn7;
    private javax.swing.JButton Box7Btn8;
    private javax.swing.JButton Box7Btn9;
    private javax.swing.JPanel Box8;
    private javax.swing.JButton Box8Btn1;
    private javax.swing.JButton Box8Btn2;
    private javax.swing.JButton Box8Btn3;
    private javax.swing.JButton Box8Btn4;
    private javax.swing.JButton Box8Btn5;
    private javax.swing.JButton Box8Btn6;
    private javax.swing.JButton Box8Btn7;
    private javax.swing.JButton Box8Btn8;
    private javax.swing.JButton Box8Btn9;
    private javax.swing.JPanel Box9;
    private javax.swing.JButton Box9Btn1;
    private javax.swing.JButton Box9Btn2;
    private javax.swing.JButton Box9Btn3;
    private javax.swing.JButton Box9Btn4;
    private javax.swing.JButton Box9Btn5;
    private javax.swing.JButton Box9Btn6;
    private javax.swing.JButton Box9Btn7;
    private javax.swing.JButton Box9Btn8;
    private javax.swing.JButton Box9Btn9;
    private javax.swing.JButton CheckBtn;
    private javax.swing.JButton ExitBtn;
    private javax.swing.JButton ResetBtn;
    private javax.swing.JPanel SelectionPanel;
    private javax.swing.JButton SolutionBtn;
    private javax.swing.JButton num1;
    private javax.swing.JButton num2;
    private javax.swing.JButton num3;
    private javax.swing.JButton num4;
    private javax.swing.JButton num5;
    private javax.swing.JButton num6;
    private javax.swing.JButton num7;
    private javax.swing.JButton num8;
    private javax.swing.JButton num9;
    // End of variables declaration//GEN-END:variables
}
