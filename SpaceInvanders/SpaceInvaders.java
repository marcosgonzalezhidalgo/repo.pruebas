package SpaceInvanders;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class SpaceInvaders extends JFrame {

    public SpaceInvaders() {
        setTitle("Space Invaders Java");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        GamePanel gamePanel = new GamePanel();
        add(gamePanel);
        pack();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SpaceInvaders());
    }

    class GamePanel extends JPanel implements ActionListener, KeyListener {
        private Timer timer;
        private Player player;
        private ArrayList<Alien> aliens;
        private ArrayList<Bullet> bullets;
        private boolean inGame = true;
        private int score = 0;
        private String message = "Game Over";

        private final int BOARD_WIDTH = 800;
        private final int BOARD_HEIGHT = 600;
        private final int DELAY = 17; // ~60 FPS

        public GamePanel() {
            setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
            setBackground(Color.BLACK);
            setFocusable(true);
            addKeyListener(this);

            initGame();
            timer = new Timer(DELAY, this);
            timer.start();
        }

        private void initGame() {
            player = new Player(BOARD_WIDTH / 2 - 15, BOARD_HEIGHT - 50);
            aliens = new ArrayList<>();
            bullets = new ArrayList<>();
            score = 0;
            inGame = true;

            int alienRows = 4;
            int alienCols = 10;
            for (int r = 0; r < alienRows; r++) {
                for (int c = 0; c < alienCols; c++) {
                    aliens.add(new Alien(50 + c * 60, 50 + r * 40));
                }
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            if (inGame) {
                drawObjects(g);
            } else {
                drawGameOver(g);
            }
            Toolkit.getDefaultToolkit().sync();
        }

        private void drawObjects(Graphics g) {
            // Draw Player
            g.setColor(Color.GREEN);
            g.fillRect(player.x, player.y, player.width, player.height);

            // Draw Aliens
            g.setColor(Color.RED);
            for (Alien alien : aliens) {
                if (alien.isVisible) {
                    g.fillRect(alien.x, alien.y, alien.width, alien.height);
                }
            }

            // Draw Bullets
            g.setColor(Color.YELLOW);
            for (Bullet bullet : bullets) {
                if (bullet.isVisible) {
                    g.fillRect(bullet.x, bullet.y, bullet.width, bullet.height);
                }
            }

            // Draw Score
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 14));
            g.drawString("Score: " + score, 10, 20);
            g.drawString("Aliens: " + aliens.size(), 10, 40);
        }

        private void drawGameOver(Graphics g) {
            String msg = message + " - Score: " + score;
            Font font = new Font("Helvetica", Font.BOLD, 24);
            FontMetrics fm = getFontMetrics(font);

            g.setColor(Color.WHITE);
            g.setFont(font);
            g.drawString(msg, (BOARD_WIDTH - fm.stringWidth(msg)) / 2, BOARD_HEIGHT / 2);

            String restartMsg = "Press R to Restart";
            g.setFont(new Font("Helvetica", Font.PLAIN, 16));
            fm = getFontMetrics(g.getFont());
            g.drawString(restartMsg, (BOARD_WIDTH - fm.stringWidth(restartMsg)) / 2, BOARD_HEIGHT / 2 + 30);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (inGame) {
                updatePlayer();
                updateBullets();
                updateAliens();
                checkCollisions();
            }
            repaint();
        }

        private void updatePlayer() {
            player.move(BOARD_WIDTH);
        }

        private void updateBullets() {
            Iterator<Bullet> it = bullets.iterator();
            while (it.hasNext()) {
                Bullet b = it.next();
                if (b.isVisible) {
                    b.move();
                } else {
                    it.remove();
                }
            }
        }

        private void updateAliens() {
            if (aliens.isEmpty()) {
                inGame = false;
                message = "You Won!";
                return;
            }

            boolean changeDirection = false;
            for (Alien alien : aliens) {
                if (alien.x + alien.width >= BOARD_WIDTH || alien.x <= 0) {
                    changeDirection = true;
                    break;
                }
            }

            for (Alien alien : aliens) {
                if (changeDirection) {
                    alien.dx = -alien.dx;
                    alien.y += 15; // Move down
                }
                alien.move();

                if (alien.y > BOARD_HEIGHT - 50) {
                    inGame = false;
                    message = "Invasion Successful!";
                }
            }
        }

        private void checkCollisions() {
            Rectangle playerRect = player.getBounds();

            for (Alien alien : aliens) {
                Rectangle alienRect = alien.getBounds();
                if (playerRect.intersects(alienRect)) {
                    inGame = false;
                    message = "Invasion Successful!";
                }
            }

            for (Bullet bullet : bullets) {
                Rectangle bulletRect = bullet.getBounds();
                Iterator<Alien> it = aliens.iterator();
                while (it.hasNext()) {
                    Alien alien = it.next();
                    Rectangle alienRect = alien.getBounds();
                    if (bullet.isVisible && alien.isVisible && bulletRect.intersects(alienRect)) {
                        bullet.isVisible = false;
                        alien.isVisible = false; // Mark for removal logic if needed, or just remove
                        it.remove();
                        score += 10;
                    }
                }
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();

            if (key == KeyEvent.VK_LEFT) {
                player.dx = -5;
            }

            if (key == KeyEvent.VK_RIGHT) {
                player.dx = 5;
            }

            if (key == KeyEvent.VK_SPACE) {
                if (inGame) {
                    bullets.add(new Bullet(player.x + player.width / 2 - 2, player.y));
                }
            }

            if (key == KeyEvent.VK_R && !inGame) {
                initGame();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();

            if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT) {
                player.dx = 0;
            }
        }

        @Override
        public void keyTyped(KeyEvent e) {
        }
    }

    // --- Entity Classes ---

    class Player {
        int x, y, dx;
        int width = 30;
        int height = 20;

        public Player(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void move(int boardWidth) {
            x += dx;
            if (x < 0)
                x = 0;
            if (x > boardWidth - width)
                x = boardWidth - width;
        }

        public Rectangle getBounds() {
            return new Rectangle(x, y, width, height);
        }
    }

    class Alien {
        int x, y, dx;
        int width = 40;
        int height = 30;
        boolean isVisible = true;

        public Alien(int x, int y) {
            this.x = x;
            this.y = y;
            this.dx = 2; // Speed
        }

        public void move() {
            x += dx;
        }

        public Rectangle getBounds() {
            return new Rectangle(x, y, width, height);
        }
    }

    class Bullet {
        int x, y;
        int width = 4;
        int height = 10;
        int speed = 10;
        boolean isVisible = true;

        public Bullet(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void move() {
            y -= speed;
            if (y < 0)
                isVisible = false;
        }

        public Rectangle getBounds() {
            return new Rectangle(x, y, width, height);
        }
    }
}
