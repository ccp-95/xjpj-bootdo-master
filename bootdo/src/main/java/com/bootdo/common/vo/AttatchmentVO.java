package com.bootdo.common.vo;

import com.bootdo.common.domain.AttatchmentDO;
import com.bootdo.common.domain.FileDO;

public class AttatchmentVO {
	
	private AttatchmentDO attatchmentDO = new AttatchmentDO();
	
	private FileDO fileDO = new FileDO();

	public AttatchmentDO getAttatchmentDO() {
		return attatchmentDO;
	}

	public void setAttatchmentDO(AttatchmentDO attatchmentDO) {
		this.attatchmentDO = attatchmentDO;
	}

	public FileDO getFileDO() {
		return fileDO;
	}

	public void setFileDO(FileDO fileDO) {
		this.fileDO = fileDO;
	}

	
}
