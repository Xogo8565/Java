package com.board.dto;

public class FileDTO {
    private int file_seq;
    private int board_seq;
    private String fileOriName;
    private String fileSysName;

    public FileDTO() {
    }

    public FileDTO(int file_seq, int board_seq, String fileOriName, String fileSysName) {
        this.file_seq = file_seq;
        this.board_seq = board_seq;
        this.fileOriName = fileOriName;
        this.fileSysName = fileSysName;
    }

    public int getFile_seq() {
        return file_seq;
    }

    public void setFile_seq(int file_seq) {
        this.file_seq = file_seq;
    }

    public int getBoard_seq() {
        return board_seq;
    }

    public void setBoard_seq(int board_seq) {
        this.board_seq = board_seq;
    }

    public String getFileOriName() {
        return fileOriName;
    }

    public void setFileOriName(String fileOriName) {
        this.fileOriName = fileOriName;
    }

    public String getFileSysName() {
        return fileSysName;
    }

    public void setFileSysName(String fileSysName) {
        this.fileSysName = fileSysName;
    }
}
