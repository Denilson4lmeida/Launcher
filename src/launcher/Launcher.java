package launcher;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.plaf.basic.BasicScrollBarUI;
import org.xml.sax.SAXException;
import java.util.Timer;
import java.util.TimerTask;

public class Launcher extends JFrame {

    private final JPanel painelFundo;
    private final JPanel painelRodape;
    private JPanel painelInternoRodape;  // Declare a variável como um membro da classe

    public Launcher() {
        // Configurações do JFrame
        setTitle("Launcher");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Tela cheia
        setUndecorated(false); // Com bordas

        // Painel de fundo (onde aparecem os aplicativos)
        painelFundo = new BackgroundPanel("src/icons/background2.jpg");
        painelFundo.setBackground(new Color(30, 30, 30));
        painelFundo.setLayout(new BorderLayout());

        JLabel titulo = new JLabel("Bem-vindo ao nosso Launcher!", SwingConstants.CENTER);
        titulo.setFont(new Font("Impact", Font.BOLD, 66)); // Fonte Impact, em negrito e tamanho 36
        titulo.setForeground(new Color(138, 43, 226)); // Cor vermelha para dar um destaque visual
        
// Para posicionar o título no centro da tela ou de um painel específico
        painelFundo.add(titulo, BorderLayout.CENTER);

        // Painel de rodapé (menu de aplicativos)
        painelRodape = new JPanel();
        painelRodape.setBackground(new Color(40, 40, 40));
        painelRodape.setLayout(new BorderLayout()); // Ajuste conforme necessário

// Lista de cores extremamente vivas para os itens do rodapé
        Color[] coresRodape = {
            new Color(255, 99, 71), // Tomato (vermelho vibrante)
            new Color(255, 165, 0), // Orange (laranja forte)
            new Color(34, 193, 195), // Aqua (verde-azulado vibrante)
            new Color(255, 105, 180), // HotPink (rosa quente)
            new Color(255, 215, 0), // Gold (dourado)
            new Color(0, 255, 255), // Cyan (ciano)
            new Color(138, 43, 226), // BlueViolet (azul violeta intenso)
            new Color(255, 20, 147), // DeepPink (rosa profundo)
            new Color(0, 255, 0), // Lime (verde limão)
            new Color(255, 69, 0), // RedOrange (laranja avermelhado)
            new Color(0, 191, 255), // DeepSkyBlue (azul céu profundo)
            new Color(255, 0, 255), // Magenta (magenta vibrante)
            new Color(255, 140, 0), // DarkOrange (laranja escuro)
            new Color(127, 255, 0), // Chartreuse (verde amarelado vibrante)
            new Color(255, 182, 193), // LightPink (rosa claro)
            new Color(221, 160, 221), // Plum (ameixa suave)
            new Color(0, 128, 128), // Teal (azul esverdeado)
            new Color(128, 0, 128), // Purple (roxo forte)
            new Color(255, 255, 0), // Yellow (amarelo forte)
            new Color(0, 0, 255), // Blue (azul intenso)
            new Color(255, 140, 255), // Orchid (orquídea)
            new Color(255, 99, 71), // Coral (coral intenso)
            new Color(204, 255, 0), // Chartreuse (verde neon)
            new Color(255, 0, 0), // Red (vermelho intenso)
            new Color(255, 105, 180), // HotPink (rosa quente)
            new Color(153, 50, 204), // DarkOrchid (roxo intenso)
            new Color(0, 250, 154), // MediumSpringGreen (verde primavera)
            new Color(255, 182, 193), // LightPink (rosa claro)
            new Color(60, 179, 113), // MediumSeaGreen (verde mar)
            new Color(255, 165, 0), // Orange (laranja brilhante)
            new Color(255, 0, 255), // Magenta (roxo vibrante)
            new Color(0, 128, 0), // Green (verde escuro)
            new Color(255, 160, 122), // LightSalmon (salmão claro)
            new Color(0, 255, 255), // Cyan (azul claro)
            new Color(72, 61, 139), // DarkSlateBlue (azul escuro)
            new Color(70, 130, 180), // SteelBlue (azul aço)
            new Color(255, 105, 180), // HotPink (rosa ardente)
            new Color(219, 112, 147), // PaleVioletRed (vermelho pálido)
            new Color(238, 130, 238), // Violet (violeta)
            new Color(255, 182, 193), // LightPink (rosa claro)
            new Color(255, 0, 255), // Fuchsia (fúcsia)
            new Color(255, 105, 180), // DeepPink (rosa vibrante)
            new Color(0, 255, 127), // SpringGreen (verde primavera claro)
            new Color(218, 165, 32), // Goldenrod (dourado escuro)
            new Color(255, 165, 0), // Orange (laranja brilhante)
            new Color(154, 205, 50), // YellowGreen (verde amarelado)
            new Color(255, 248, 220), // Cornsilk (milho)
            new Color(34, 139, 34), // ForestGreen (verde floresta)
            new Color(139, 0, 0), // DarkRed (vermelho escuro)
            new Color(255, 192, 203), // Pink (rosa claro)
            new Color(255, 250, 205), // LemonChiffon (creme de limão)
            new Color(0, 139, 139), // DarkCyan (ciano escuro)
            new Color(0, 206, 209), // DarkTurquoise (turquesa escuro)
            new Color(221, 160, 221), // Plum (ameixa)
            new Color(255, 99, 71), // Tomato (tomate)
            new Color(135, 206, 250), // LightSkyBlue (azul claro)
            new Color(0, 0, 255), // Blue (azul forte)
            new Color(135, 206, 235), // SkyBlue (azul céu)
            new Color(184, 134, 11), // DarkGoldenrod (dourado escuro)
            new Color(255, 218, 185), // PeachPuff (pêssego suave)
            new Color(139, 69, 19), // SaddleBrown (marrom)
            new Color(255, 99, 71) // Tomato (vermelho vibrante)
        };

        // Timer para alternar cores dos itens no rodapé com transição suave
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            int index = 0;
            float progress = 0.0f; // Progressão da interpolação entre as cores

            @Override
            public void run() {
                SwingUtilities.invokeLater(() -> {
                    // Graduação suave da cor atual para a próxima
                    Color corAtual = coresRodape[index];
                    Color corProxima = coresRodape[(index + 1) % coresRodape.length];

                    // Interpolação linear de cor entre corAtual e corProxima
                    int r = (int) (corAtual.getRed() + (corProxima.getRed() - corAtual.getRed()) * progress);
                    int g = (int) (corAtual.getGreen() + (corProxima.getGreen() - corAtual.getGreen()) * progress);
                    int b = (int) (corAtual.getBlue() + (corProxima.getBlue() - corAtual.getBlue()) * progress);

                    Color corInterpolada = new Color(r, g, b);

                    // Atualiza as bordas dos painéis com a cor interpolada
                    for (Component comp : painelInternoRodape.getComponents()) {
                        if (comp instanceof JPanel) {
                            JPanel painel = (JPanel) comp;
                            painel.setBorder(BorderFactory.createLineBorder(corInterpolada, 3)); // Borda com cor interpolada
                        }
                    }

                    // Incremento mais suave de progress
                    progress += 0.05f;  // Transição mais suave

                    // Garantir que a cor seja atualizada corretamente
                    if (progress >= 1.0f) {
                        progress = 0.0f;
                        index = (index + 1) % coresRodape.length;  // Garante que o índice não ultrapasse o tamanho da lista
                    }

                });
            }
        }, 10, 200); // Troca a cada 100ms, ajustando a suavidade da transição

        // Inicializando o painelInternoRodape antes de usar
        painelInternoRodape = new JPanel();
        painelInternoRodape.setBackground(new Color(40, 40, 40));
        painelInternoRodape.setLayout(new BoxLayout(painelInternoRodape, BoxLayout.X_AXIS));

        // Carregar aplicativos dinamicamente
        List<Aplicativo> aplicativos = carregarAplicativos();
        for (Aplicativo app : aplicativos) {
            JPanel item = criarItemMenu(app);
            painelInternoRodape.add(item);
        }

        // Ajuste a largura com base no número de itens
        int larguraItens = 200 * aplicativos.size(); // Ajuste conforme o número de itens
        painelInternoRodape.setPreferredSize(new Dimension(larguraItens, 250));  // Largura aumentada

        // Adicionar JScrollPane com rolagem horizontal
        JScrollPane scrollRodape = new JScrollPane(painelInternoRodape, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollRodape.setPreferredSize(new Dimension(100, 50));  // Ajuste para ocupar mais espaço

        // Adicionar o JScrollPane ao painelRodape
        painelRodape.add(scrollRodape, BorderLayout.CENTER);
        painelRodape.setPreferredSize(new Dimension(200, 280));  // Ajuste conforme necessário

        // Adicionar os painéis ao JFrame
        add(painelFundo, BorderLayout.CENTER);
        add(painelRodape, BorderLayout.SOUTH);

        // Personalizar as barras de rolagem do JScrollPane
        UIManager.put("ScrollBar.thumb", new javax.swing.plaf.ColorUIResource(new Color(100, 100, 255)));  // Cor da parte rolável (thumb)
        UIManager.put("ScrollBar.track", new javax.swing.plaf.ColorUIResource(new Color(50, 50, 50)));   // Cor da trilha (track)
        UIManager.put("ScrollBar.arrow", new javax.swing.plaf.ColorUIResource(new Color(255, 255, 255)));  // Cor das setas (se tiver)

        // Atualizar a aparência da interface
        SwingUtilities.updateComponentTreeUI(this);

        JScrollBar horizontalBar = scrollRodape.getHorizontalScrollBar();
        horizontalBar.setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = new Color(100, 100, 255);  // Cor da parte rolável
                this.trackColor = new Color(50, 50, 50);     // Cor da trilha
            }
        });

        // Exibir o JFrame
        setVisible(true);
    }

    //imagem de fundo
    class BackgroundPanel extends JPanel {

        private final Image backgroundImage;

        public BackgroundPanel(String imagePath) {
            this.backgroundImage = new ImageIcon(imagePath).getImage();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

    // Método para criar um item de menu (ícone + nome)
    private JPanel criarItemMenu(Aplicativo app) {
        JPanel item = new JPanel();
        item.setPreferredSize(new Dimension(190, 220)); // Define o tamanho do painel
        item.setLayout(new BorderLayout());
        item.setBackground(new Color(60, 60, 60));
        item.setBorder(BorderFactory.createLineBorder(new Color(90, 90, 90), 2));
        item.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // Ícone (redimensionado)
        ImageIcon originalIcon = new ImageIcon(app.getCaminhoIcone());
        Image imagemRedimensionada = originalIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(imagemRedimensionada);

        JLabel iconeLabel = new JLabel(resizedIcon);
        iconeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        item.add(iconeLabel, BorderLayout.CENTER);

        // Nome do aplicativo
        JLabel nomeLabel = new JLabel(app.getNome(), SwingConstants.CENTER);
        nomeLabel.setForeground(Color.BLACK);
        nomeLabel.setFont(new Font("Arial", Font.BOLD, 14));
        item.add(nomeLabel, BorderLayout.SOUTH);

        // Evento de clique para exibir detalhes no painel de fundo
        item.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                item.setBackground(new Color(80, 80, 80)); // Muda a cor do item
                exibirNoPainelFundo(app); // Exibe informações no painel de fundo
            }

            @Override
            public void mouseExited(MouseEvent e) {
                item.setBackground(new Color(60, 60, 60)); // Volta à cor original do item
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                executarAplicativo(app); // Executa o aplicativo
            }
        });
        return item;
    }

    private void executarAplicativo(Aplicativo app) {
        try {
            // Executa o comando associado ao aplicativo
            Process proc = new ProcessBuilder("java", "-jar", app.getCaminhoJar()).start();
            System.out.println("Executando: " + app.getNome());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao executar o aplicativo: " + app.getNome(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para exibir informações no painel de fundo
    private void exibirNoPainelFundo(Aplicativo app) {
        painelFundo.removeAll();

        JLabel titulo = new JLabel("" + app.getNome(), SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setForeground(Color.WHITE);

        ImageIcon icon = new ImageIcon(app.getCaminhoIcone());
        JLabel iconeLabel = new JLabel(icon);
        iconeLabel.setHorizontalAlignment(SwingConstants.CENTER);

        painelFundo.add(titulo, BorderLayout.NORTH);
        painelFundo.add(iconeLabel, BorderLayout.CENTER);

        painelFundo.revalidate();
        painelFundo.repaint();
    }

    // Método para carregar aplicativos a partir de um arquivo XML
    private List<Aplicativo> carregarAplicativos() {
        List<Aplicativo> aplicativos = new ArrayList<>();

        try {
            // Localize o arquivo XML
            File arquivoXML = new File("src/resources/aplicativos.xml");

            // Parse o arquivo XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(arquivoXML);

            // Normaliza a estrutura do XML
            document.getDocumentElement().normalize();

            // Obtém todos os elementos "aplicativo"
            NodeList nodeList = document.getElementsByTagName("aplicativo");

            // Itera por cada elemento
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) node;

                    // Lê os valores do XML
                    String nome = elemento.getElementsByTagName("nome").item(0).getTextContent();
                    String icone = elemento.getElementsByTagName("icone").item(0).getTextContent();
                    String caminhoJar = elemento.getElementsByTagName("caminhoJar").item(0).getTextContent();

                    // Cria um novo aplicativo
                    aplicativos.add(new Aplicativo(nome, icone, caminhoJar));
                }
            }
        } catch (IOException | ParserConfigurationException | DOMException | SAXException e) {
        }

        return aplicativos;
    }

    // Classe para representar um aplicativo
    static class Aplicativo {

        private final String nome;
        private final String caminhoIcone;
        private final String caminhoJar;

        public Aplicativo(String nome, String caminhoIcone, String caminhoJar) {
            this.nome = nome;
            this.caminhoIcone = caminhoIcone;
            this.caminhoJar = caminhoJar;
        }

        public String getNome() {
            return nome;
        }

        public String getCaminhoIcone() {
            return caminhoIcone;
        }

        public String getCaminhoJar() {
            return caminhoJar;
        }
    }

    // Método principal para inicializar o launcher
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Launcher::new);
    }
}
