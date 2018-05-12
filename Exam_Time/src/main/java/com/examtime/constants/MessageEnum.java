package com.examtime.constants;

import com.project.examtime.framework.utils.BasePropertyEnum;

/**
	 * 
	 * @author Harish
	 *
	 */
	public enum MessageEnum implements BasePropertyEnum {
		SYSTEMEXCEPTION("systemException"),
		UNEXPECTEDFAILURE("failure"),
		EXCELNODATA("excelNoData"),
		EXCELCELLERROR("excelCellError"),
		EXCELFILEINVALID("excelFileInvalid"),
		EXCELINVALIDHEADER("excelInvalidHeader"),
		EXCELCELLCONVERSIONERROR("excelCellConversionError"),
		EXCELINVALIDCOLUMN("excelInvalidColumn"),
		EXCELTYPEMISMATCH("excelTypeMisMatch"),
		EXCELBLANKROW("excelBlankRow"),
		EXCELNOADD("excelNoAdd"),
		EXCELNOOVERWRITE("excelNoOverwrite"),
		EXCELADDENTRIES("excelAddEntries"),
		INVALIDPRODUCTID("invalidProductId"),
		INVALIDEXCELPROPERTY("invalidExcelProperty"),
		DUPLICATEPRODUCTID("duplicateProductId"),
		DUPLICATEPARTYID("duplicatePartyId"),
		INVALIDPARTYID("invalidPartyId"),
		CONCURRENTMSG("conCurrentMsg"),
		LOGIN_NAME_ALREADY_EXISTS("userAleradyExist"),
		LOGIN_SUCCESS("Userloginsuccesfylly"),
		LOGIN_FAIL("YourEnterdUSerNameorPasswordisWrong"),
		DUPLICATEVEHICLENUMBER("inValidVehicleNumber"),
		CARID_NOTAVILABLE("Given car is Not Availbel."),
		EMAILSEND_FAILD("emaiSendFaild"),
		EMAIL_VALIDATION("givenEmailNotValid"),
		USERNAME_VALDATE("givenUserNamenotExist"),
		IMAGE_NOT_FOUND("imageNotFound"),
		USER_DEACTIVATED("userdeactivated");
		
		public String key;
		public String bundleName = "com.project.examtime.lap.messages";
		public Integer statusCode=501;
		
		

		MessageEnum(String key) {
			this.key = key;
		}

		@Override
		public String getBundle() {
			return bundleName;
		}

		@Override
		public String getKey() {
			return key;
		}

		public Integer getStatusCode() {
			return statusCode;
		}

	}



