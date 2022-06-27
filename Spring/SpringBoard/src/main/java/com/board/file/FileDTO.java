package com.board.file;

public class FileDTO {
    private int seq_file;
    private int seq_board;
    private String file_name;

    public FileDTO() {
    }

    public FileDTO(int seq_file, int seq_board, String file_name) {
        this.seq_file = seq_file;
        this.seq_board = seq_board;
        this.file_name = file_name;
    }

    public int getSeq_file() {
        return seq_file;
    }

    public void setSeq_file(int seq_file) {
        this.seq_file = seq_file;
    }

    public int getSeq_board() {
        return seq_board;
    }

    public void setSeq_board(int seq_board) {
        this.seq_board = seq_board;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }
}
