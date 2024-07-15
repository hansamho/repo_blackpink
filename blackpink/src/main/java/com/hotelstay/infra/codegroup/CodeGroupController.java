package com.hotelstay.infra.codegroup;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.hotelstay.common.base.BaseService;
import com.hotelstay.common.contents.Constants;
import com.hotelstay.common.util.UtilDateTime;
import com.hotelstay.infra.code.CodeDto;
import com.hotelstay.infra.code.CodeVo;

import jakarta.servlet.http.HttpServletResponse;
@Controller
public class CodeGroupController {
	
	@Autowired
	CodeGroupService service;
//	CodeGroupService codeGroupService;
	
	@Autowired
	BaseService baseService;
	
	
	public void setSearch(CodeGroupVo vo) throws Exception {
		/* 최초 화면 로딩시에 세팅은 문제가 없지만 */
		/*이후 전체적으로 데이터를 조회를 하려면 null 값이 넘어 오는 관계로 문제가 전체 데이터 조회가 되지 못한다.*/
		/*해서 BaseVo.java 에서 기본값을 주어서 처리*/
//		vo.setShUseNy(vo.getShUseNy() == null ? 1 : vo.getShUseNy());
//		vo.setShDelNy(vo.getShDelNy() == null ? 0 : vo.getShDelNy());
//		vo.setShOptionDate(vo.getShOptionDate() == null ? 2 : vo.getShOptionDate());
		
		/* 초기값 세팅이 있는 경우 사용 */
		vo.setShDateStart(vo.getShDateStart() == null
		    ? UtilDateTime.calculateDayReplace00TimeString(UtilDateTime.nowLocalDateTime(), Constants.DATE_INTERVAL)
		    : UtilDateTime.add00TimeString(vo.getShDateStart()));
		vo.setShDateEnd(vo.getShDateEnd() == null
		    ? UtilDateTime.nowString()
		    : UtilDateTime.add59TimeString(vo.getShDateEnd()));		
		
//		/* 초기값 세팅이 없는 경우 사용 */
//		vo.setShDateStart(vo.getShDateStart() == null || vo.getShDateStart() == "" ? null : UtilDateTime.add00TimeString(vo.getShDateStart()));
//		vo.setShDateEnd(vo.getShDateEnd() == null || vo.getShDateEnd() == "" ? null : UtilDateTime.add59TimeString(vo.getShDateEnd()));
		
		
	}
	
	
	
	@RequestMapping(value = "/codeGroupXdmList")
	public String codeGroupXdmList(@ModelAttribute("vo") CodeGroupVo vo, Model model) throws Exception{
			
			setSearch(vo);
			
        return "adm/infra/codegroup/codeGroupXdmList";
  	}
	
	
	@RequestMapping(value="/codeGroupAjaxLita")
	public String codeGroupAjaxLita(@ModelAttribute("vo") CodeGroupVo vo, Model model) throws Exception{
		
//		setSearch(vo);
		model.addAttribute("count", service.selectOneCount(vo));
		
		vo.setParamsPaging(service.selectOneCount(vo));
		
		
		if (vo.getTotalRows() > 0) {
			model.addAttribute("list", service.selectList(vo));
		}
		
		return "adm/infra/codegroup/codeGroupAjaxLita";
	}
	
	
	@RequestMapping(value = "/codeGroupAdmView")
		public String codeGroupAdmView(CodeGroupDto dto, Model model) throws Exception{
			model.addAttribute("item", service.selectOne(dto));
		
			return "adm/infra/codegroup/codeGroupAdmView"; //
			
		}
	@RequestMapping(value = "/codeGroupForm")
	public String codeGroupForm(CodeGroupDto dto, Model model) throws Exception{
		model.addAttribute("item", service.selectOne(dto));
	
		return "adm/infra/codegroup/codeGroupForm"; //
		
	}
	
	@RequestMapping(value = "/codeGroupAdd")
	public String codeGroupAdd() throws Exception{
		
	
		return "adm/infra/codegroup/codeGroupAdd"; //
		
	}
	
	@RequestMapping(value = "/cgInsert")
	public String cgInsert(CodeGroupDto dto) throws Exception{
		
		
//		System.out.println("dto.getUploadFiles().length:"+dto.getUploadFiles().length);
//		
//		for(MultipartFile a : dto.getUploadFiles()) {
//			System.out.println("a.getOriginalFilename():"+a.getOriginalFilename());
//		}
		
		service.insert(dto);
		
		
		
		return "redirect:/codeGroupXdmList"; //
		
	}
	
	@RequestMapping(value = "/codeGroupUpdt")
	public String codeGroupUpdt(CodeGroupDto dto) throws Exception{

		service.update(dto);
		
		return "redirect:/codeGroupXdmList";
		
	}
	
	@RequestMapping(value = "/codeGroupUpdtDt")
	public String codeGroupUpdtDt(CodeGroupDto dto) throws Exception{

		service.updateDelete(dto);
		
		return "redirect:/codeGroupXdmList"; //
		
	}
	
	@RequestMapping(value = "/codeGroupDelete")
	public String codeGroupDelete(CodeGroupDto dto) throws Exception{

		service.delete(dto);
		
		return "redirect:/codeGroupXdmList"; //
		
	}
	
	//엑셀
	
	@RequestMapping(value="/excelDownload")
    public void excelDownload(CodeGroupVo vo, HttpServletResponse httpServletResponse) throws Exception {
		
		setSearch(vo);
		vo.setParamsPaging(service.selectOneCount(vo));

		if (vo.getTotalRows() > 0) {
			List<CodeGroupDto> list = service.selectList(vo);
			
		//  Workbook workbook = new HSSFWorkbook();	// for xls
	        Workbook workbook = new XSSFWorkbook();
	        Sheet sheet = workbook.createSheet("첫번째 시트");
	        CellStyle cellStyle = workbook.createCellStyle();        
	        Row row = null;
	        Cell cell = null;
	        int rowNum = 0;
			
//	        each column width setting
	        sheet.setColumnWidth(0, 2100);
	        sheet.setColumnWidth(1, 3100);

//	        Header
	        String[] tableHeader = {"코드그룹 코드", "코드그룹 이름", "삭제여부", "등록일", "수정일"};

	        row = sheet.createRow(rowNum++);
			for(int i=0; i<tableHeader.length; i++) {
				cell = row.createCell(i);
	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
	        	cell.setCellStyle(cellStyle);
				cell.setCellValue(tableHeader[i]);
			}

//	        Body
	        for (int i=0; i<list.size(); i++) {
	            row = sheet.createRow(rowNum++);
	            
//	            String type: null 전달 되어도 ok
//	            int, date type: null 시 오류 발생 하므로 null check
//	            String type 이지만 정수형 데이터가 전체인 seq 의 경우 캐스팅
	            
	            cell = row.createCell(0);
	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
	        	cell.setCellStyle(cellStyle);
	            cell.setCellValue(Integer.parseInt(list.get(i).getCgSeq()));
	            
	            cell = row.createCell(1);
	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
	        	cell.setCellStyle(cellStyle);
	        	cell.setCellValue(list.get(i).getName());
	        	
//	            cell = row.createCell(2);
//	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
//	        	cell.setCellStyle(cellStyle);
//	        	cell.setCellValue(Integer.parseInt(list.get(i).getIfcdSeq()));
//	        	
//	            cell = row.createCell(3);
//	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
//	        	cell.setCellStyle(cellStyle);
//	        	cell.setCellValue(list.get(i).getIfcdSeqAnother());
//	            
//	            cell = row.createCell(4);
//	            cellStyle.setAlignment(HorizontalAlignment.CENTER);
//	            cell.setCellStyle(cellStyle);
//	            cell.setCellValue(list.get(i).getIfcdName());
//	            
//	            cell = row.createCell(5);
//	            cellStyle.setAlignment(HorizontalAlignment.CENTER);
//	            cell.setCellStyle(cellStyle);
//	            cell.setCellValue(list.get(i).getIfcdNameEng());
//     
	            cell = row.createCell(2);
	            cellStyle.setAlignment(HorizontalAlignment.CENTER);
	            cell.setCellStyle(cellStyle);
	            if(list.get(i).getCgDelny() != null) cell.setCellValue(list.get(i).getCgDelny() == 0 ? "N" : "Y");
	            
//	            cell = row.createCell(7);
//	            cellStyle.setAlignment(HorizontalAlignment.CENTER);
//	            cell.setCellStyle(cellStyle);
//	            if(list.get(i).getIfcdOrder() != null) cell.setCellValue(list.get(i).getIfcdOrder());
	            
	            cell = row.createCell(3);
	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
	        	cell.setCellStyle(cellStyle);
	        	if(list.get(i).getCgRegDate() != null) cell.setCellValue(UtilDateTime.dateTimeToString(list.get(i).getCgRegDate()));
	        	
	        	cell = row.createCell(4);
	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
	        	cell.setCellStyle(cellStyle);
	        	if(list.get(i).getCgUpdate() != null) cell.setCellValue(UtilDateTime.dateTimeToString(list.get(i).getCgUpdate()));
	        }

	        httpServletResponse.setContentType("ms-vnd/excel");
//	        httpServletResponse.setHeader("Content-Disposition", "attachment;filename=example.xls");	// for xls
	        httpServletResponse.setHeader("Content-Disposition", "attachment;filename=example.xlsx");

	        workbook.write(httpServletResponse.getOutputStream());
	        workbook.close();
		}
    }
}