package com.biz.iolist.model;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductVO {
	private long io_seq;//	number
	private String io_date;	//	varchar2(10)
	private String io_time;	//	varchar2(10)
	private String io_pname;	//	nvarchar2(30)
	private boolean io_inout;	//	char(1)
	private int io_price;	//	number
	private int io_quan;	//	number
	private int io_total;	//	number
	
	private int io_in_sum;
	private int io_out_sum;
}
