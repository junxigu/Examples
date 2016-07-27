package com.tableAdmin.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.util.Date;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

import com.dao.ServiceMerchantTokenDao;
import com.daoFactory.DaoFactory;
import com.domain.ServiceMerchantToken;
import com.util.DESedeEncryption;

public class ServiceMerchantTokenAdminService {

	private ServiceMerchantTokenDao merchantTokenDao;

	private DESedeEncryption enDecryptionUtil;

	public ServiceMerchantTokenAdminService(DaoFactory daoFactory,
			DESedeEncryption enDecryptionUtil) {
		this.merchantTokenDao = daoFactory.getServiceMerchantTokenDao();
		this.enDecryptionUtil = enDecryptionUtil;
	}

	public List<ServiceMerchantToken> fetch() throws IOException,
			InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		List<ServiceMerchantToken> tokens = merchantTokenDao
				.getMerchantTokens();
		for (ServiceMerchantToken token : tokens) {
			decriptTokenAliasAndPass(token);
		}
		return tokens;
	}

	public void encriptTokenAliasAndPass(ServiceMerchantToken merchantToken)
			throws InvalidKeyException, UnsupportedEncodingException,
			IllegalBlockSizeException, BadPaddingException {
		merchantToken.setAlias(enDecryptionUtil.encrypt(merchantToken
				.getAlias()));
		merchantToken.setPassword(enDecryptionUtil.encrypt(merchantToken
				.getPassword()));
	}

	public void decriptTokenAliasAndPass(ServiceMerchantToken merchantToken)
			throws InvalidKeyException, IllegalBlockSizeException,
			BadPaddingException, IOException {
		merchantToken.setAlias(enDecryptionUtil.decrypt(merchantToken
				.getAlias()));
		merchantToken.setPassword(enDecryptionUtil.decrypt(merchantToken
				.getPassword()));
	}

	public ServiceMerchantToken insert(ServiceMerchantToken merchantToken)
			throws IOException, InvalidKeyException, IllegalBlockSizeException,
			BadPaddingException {
		merchantToken.setCreationTime(new Date());
		ServiceMerchantToken tempToken = new ServiceMerchantToken(merchantToken);
		encriptTokenAliasAndPass(tempToken);
		int count = merchantTokenDao.insertMerchantToken(tempToken);
		merchantToken.setId(tempToken.getId());
		return count > 0 ? merchantToken : null;
	}

	public ServiceMerchantToken delete(ServiceMerchantToken merchantToken)
			throws IOException {
		return merchantTokenDao.deleteMerchantToken(merchantToken.getId()) > 0 ? merchantToken
				: null;
	}

	public ServiceMerchantToken update(ServiceMerchantToken merchantToken)
			throws IOException, InvalidKeyException, IllegalBlockSizeException,
			BadPaddingException {
		merchantToken.setUpdateTime(new Date());
		ServiceMerchantToken tempToken = new ServiceMerchantToken(merchantToken);
		encriptTokenAliasAndPass(tempToken);
		return merchantTokenDao.updateMerchantToken(tempToken) > 0 ? merchantToken
				: null;
	}

}
