package hello.upload.domain;

import lombok.Data;

@Data
public class UploadFile {

    //사용자가 입력한 파일 이름
    private String uploadFileName;

    //시스템에서 저장하는 파일이름 - 여러 사용자가 동일한 파일 이름을 사용할수도 있기 때문에, 시스템에 저장시에는 별도의 파일 이름을 만듦

    private String storeFileName;

    public UploadFile(String uploadFileName, String storeFileName) {
        this.uploadFileName = uploadFileName;
        this.storeFileName = storeFileName;
    }
}
