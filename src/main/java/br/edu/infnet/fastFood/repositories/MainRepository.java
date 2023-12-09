package br.edu.infnet.fastFood.repositories;

import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MainRepository {

    public static void main(String[] args) {
        try {
            String directoryName = "temp";
            String fileName = "arquivo_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss")) + ".txt";

            Runnable criarDiretorioEArquivo = () -> {
                try {

                    Path directoryPath = Paths.get(directoryName);
                    if (Files.notExists(directoryPath)) {
                        Files.createDirectory(directoryPath);
                        System.out.println("Diretório criado: " + directoryPath.toAbsolutePath());
                    }

                    Path filePath = directoryPath.resolve(fileName);

                    Files.createFile(filePath);
                    System.out.println("Arquivo criado: " + filePath.toAbsolutePath());

                    long fileSize = Files.size(filePath);
                    String fileType = Files.probeContentType(filePath);

                    String content = "Nome do Arquivo: " + fileName + "\n";
                    content += "Data de criação: " + LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) + "\n";
                    content += "Tamanho do arquivo: " + fileSize + " bytes\n";
                    content += "Tipo do arquivo: " + fileType + "\n";

                    Files.writeString(filePath, content, StandardOpenOption.WRITE);
                    System.out.println("Informações inseridas no arquivo.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            };

            criarDiretorioEArquivo.run();

            String fileContent = Files.readString(Paths.get(directoryName, fileName));

            System.out.println("\nConteúdo do arquivo:");
            System.out.println("Data de criação: " + buscaInfoPorChave(fileContent, "Data de criação"));
            System.out.println("Nome do Arquivo: " + buscaInfoPorChave(fileContent, "Nome do Arquivo"));
            System.out.println("Tamanho do arquivo: " + buscaInfoPorChave(fileContent, "Tamanho do arquivo"));
            System.out.println("Tipo do arquivo: " + buscaInfoPorChave(fileContent, "Tipo do arquivo"));

        } catch (FileAlreadyExistsException e) {
            System.err.println("Erro: O arquivo já existe.");
        } catch (IOException e) {
            System.err.println("Erro de I/O: " + e.getMessage());
        }
    }

    private static String buscaInfoPorChave(String content, String key) {
        int startIndex = content.indexOf(key);
        if (startIndex == -1) {
            return "Informação não encontrada";
        }

        startIndex += key.length() + 2;
        int endIndex = content.indexOf('\n', startIndex);

        if (endIndex == -1) {
            endIndex = content.length();
        }

        return content.substring(startIndex, endIndex).trim();
    }
}