package com.cskaoyan.erp.service.impl;


import com.cskaoyan.erp.dao.*;
import com.cskaoyan.erp.model.*;

import com.cskaoyan.erp.dao.DeviceMaintainDao;
import com.cskaoyan.erp.dao.UnQualifyApplyDao;
import com.cskaoyan.erp.model.DeviceMaintain;
import com.cskaoyan.erp.model.UnQualifyApply;

import com.cskaoyan.erp.service.ErpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("erpService")
public class ErpServiceImpl implements ErpService {


    /*****************计划进度接口实现*************************************/
    @Autowired
    private COrderDao cOrderDao;


    @Autowired
    private CustomDao customDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private WorkDao workDao;

    @Autowired
    private ManufactureDao manufactureDao;

    @Autowired
    private TaskDao taskDao;

    /**------------------------------Order--------------------------------*/

    /**
     * 查询订单API的实现
     *
     * @return
     * @see { ErpService }
     */
    @Override
    public List<COrder> findCOrder() {
        return cOrderDao.selectALLCOder();
    }

    @Override
    public COrder findCOrderById(String id) {
        return cOrderDao.selectCOrderById(id);
    }

    @Override
    public int addOrder(COrder cOrder) {
        return cOrderDao.insertOrder(cOrder);
    }

    @Override
    public int editOrder(COrder cOrder) {
        return cOrderDao.updateOrder(cOrder);
    }

    @Override
    public int deleteOrder(String[] ids) {
        return cOrderDao.deleteOrderByIds(ids);
    }

    /**
     * ------------------------------Custom--------------------------------
     */
    @Override
    public List<Custom> findCustom() {
        return customDao.selectAllCustom();
    }

    @Override
    public Custom findCustomById(String id) {
        return customDao.selectCustomById(id);
    }

    @Override
    public int addCustom(Custom custom) {
        return customDao.insertCustom(custom);
    }

    @Override
    public int editCustom(Custom custom) {
        return customDao.updateCustom(custom);
    }

    @Override
    public int deleteCustom(String[] ids) {
        return customDao.deleteCustomByIds(ids);
    }

    /** ------------------------------Product--------------------------------*/
    @Override
    public List<Product> findProduct() {
        return productDao.selectAllProduct();
    }

    @Override
    public Product findProductById(String id) {
        return productDao.selectProductById(id);
    }

    @Override
    public int addProduct(Product product) {
        return productDao.insertProduct(product);
    }

    @Override
    public int editProduct(Product product) {
        return productDao.updateProduct(product);
    }

    @Override
    public int deleteProduct(String[] ids) {
        return productDao.deleteProductById(ids);
    }

    /** ------------------------------Work--------------------------------*/
    @Override
    public List<Work> findWork() {
        return workDao.selectAllWork();
    }

    @Override
    public Work findWorkById(String id) {
        return workDao.selectWorkById(id);
    }

    @Override
    public int addWork(Work work) {
        return workDao.insertWork(work);
    }

    @Override
    public int editWork(Work work) {
        return workDao.updateWork(work);
    }

    @Override
    public int deleteWork(String[] ids) {
        return workDao.deleteWorkByIds(ids);
    }

    /**------------------------------Manufacture--------------------------------*/

    @Override
    public List<Manufacture> findManufacture() {
        return manufactureDao.selectAllManufacture();
    }

    @Override
    public Manufacture findManufactureById(String id) {
        return manufactureDao.selectManufactureById(id);
    }

    /**------------------------------Task--------------------------------*/
    @Override
    public List<Task> findTask() {
        return taskDao.selectAllTask();
    }

    @Override
    public Task findTaskById(String id) {
        return taskDao.selectTaskById(id);
    }

    @Override
    public int addTask(Task task) {
        return taskDao.insertTask(task);
    }

    @Override
    public int editTask(Task task) {
        return taskDao.updateTask(task);
    }

    @Override
    public int deleteTask(String[] ids) {
        return taskDao.deleteTaskByIds(ids);
    }

    /*****************设备管理接口实现*************************************/
    @Autowired
    DeviceMaintainDao deviceMaintainDao;
    @Autowired
    DeviceTypeDao deviceTypeDao;
    @Autowired
    DeviceFaultDao deviceFaultDao;
    @Autowired
    DeviceDao deviceDao;
    @Autowired
    DeviceCheckDao deviceCheckDao;

    /*-------------设备分类模块------------------------------------------------*/

    @Override
    public List<DeviceType> findDeviceTypeByPage() {
        return deviceTypeDao.findAllDeviceType();
    }
    @Override
    public int insertDeviceType(DeviceType deviceType) {
        return deviceTypeDao.insertDeviceType(deviceType);
    }
    @Override
    public int updateDeviceType(DeviceType deviceType) {
        return deviceTypeDao.modifyDeviceTypeById(deviceType);
    }
    @Override
    public int deleteDeviceType(String id) {
        return deviceTypeDao.deleteDeviceTypeById(id);
    }
    @Override
    public List<DeviceType> findDeviceTypeById(String searchValue) {
        return deviceTypeDao.findDeviceTypeById(searchValue);
    }
    @Override
    public List<DeviceType> findDeviceTypeByName(String searchValue) {
        return deviceTypeDao.findDeviceTypeByName(searchValue);
    }


    /*-------------设备模块----------------------------------------------------*/
    @Override
    public List<Device> findDeviceByPage() {
        return deviceDao.findAllDevice();
    }

    @Override
    public int insertDevice(Device device) {
        return deviceDao.insertDevice(device);
    }

    @Override
    public int updateDevice(Device device) {
        return deviceDao.updateDeviceById(device);
    }

    @Override
    public int deleteDevice(String id) {
        return deviceDao.deleteDeviceById(id);
    }

    @Override
    public List<DeviceType> findDeviceById(String searchValue) {
        return deviceDao.findDeviceById(searchValue);
    }

    @Override
    public List<DeviceType> findServiceDeviceById(String id) {
        return deviceDao.findServiceDeviceById(id);
    }

    @Override
    public List<DeviceType> findDeviceByName(String searchValue) {
        return deviceDao.findDeviceByName(searchValue);
    }

    @Override
    public int updateDeviceNote(Device device) {
        return deviceDao.updateDeviceNote(device);
    }



    /*-------------设备例检模块------------------------------------------------*/
    @Override
    public List<DeviceCheck> findDeviceeCheckByPage() {
        return deviceCheckDao.findAllDeviceCheck();
    }
    /*-------------设备故障模块------------------------------------------------*/
    @Override
    public List<DeviceFault> findAllDeviceFaultByPage() {
        return  deviceFaultDao.findAllDeviceFault();
    }
    /*-------------设备维修模块------------------------------------------------*/
    @Override
    public List<DeviceMaintain> findDeviceMaintainByPage() {
        return deviceMaintainDao.findAllDeviceMaintain();
    }


    /*****************工艺监控接口实现*************************************/


    /*****************物料监控接口实现*************************************/
    /*-------------物料信息模块------------------------------------------------*/
    @Autowired
    private MaterialDao materialDao;
    @Autowired
    private MaterialReceiveDao materialReceiveDao;
    @Override
    public List<Material> selectMaterial() {
        return materialDao.selectMaterial();
    }

    @Override
    public int selectCountOfMaterial() {
        return materialDao.count();
    }

    @Override
    public int removeMaterialById(String id) {
        return  materialDao.deleteById(id);
    }

    @Override
    public int modifyMaterial(Material material) {
        return materialDao.update(material);
    }

    @Override
    public int addMaterial(Material material) {
        return  materialDao.addMaterial(material);
    }

    @Override
    public List<Material> selectMaterialById(String searchValue) {
        return materialDao.selectByID(searchValue);
    }

    @Override
    public List<Material> selectMaterialByType(String searchValue) {
        return materialDao.selectByType(searchValue);
    }


    @Override
    public int modifyNote(Material material) {
         return materialDao.updateNote(material);
    }


    /*-------------物料收入模块------------------------------------------------*/
    @Override
    public List<MaterialReceive> selectMaterialReceive() {
        return materialReceiveDao.selectMaterialReceive();
    }

    @Override
    public int selectCountOfMaterialReceive() {
        return materialReceiveDao.CountOfMaterialReceive();
    }
    /*****************质量监控接口实现*************************************/
//    ------------------不合格品管理-------------------
        //**********注入Dao
    @Autowired
    private UnQualifyApplyDao unQualifyApplyDao;
        //***********查询不合格品
    @Override
    public List<UnQualifyApply> findUnqualifyList() {

        List<UnQualifyApply> unqualifyListDao = unQualifyApplyDao.findUnqualifyListDao();
        return unqualifyListDao;
    }
        //************新建不合格品
    @Override
    public int addUnqualifyService(UnQualifyApply unQualifyApply) {
        return unQualifyApplyDao.addUnqualifyDao(unQualifyApply);
    }
        //***********修改不合格品

    @Override
    public int updateUnqualifyService(UnQualifyApply unQualifyApply) {
        return  unQualifyApplyDao.updateUnqualifyDao(unQualifyApply);
    }
        //**********删除不合格品(可为多条)
    @Override
    public int deleteUnqualifyService(String[] ids) {
        return unQualifyApplyDao.deleteUnqualifyDao(ids);
    }
    //*************修改不合格品备注功能
    @Override
    public int updateNoteUnqualifyService(String unqualifyApplyId, String note) {
        return unQualifyApplyDao.updateNoteByUnqualifyApplyIdDao(unqualifyApplyId,note);
    }
//-------------------------成品计量质检--------------------------------------
//-------------------------成品计数质检--------------------------------------
//-------------------------工序计量质检--------------------------------------
    //************注入Dao
    @Autowired
    private ProcessMeasureCheckDao processMeasureCheckDao;
    //***********查询工序计量质检列表
    @Override
    public List<ProcessMeasureCheck> findPMeasureCheck() {
        List<ProcessMeasureCheck> list = processMeasureCheckDao.findPMeasureCheckDao();
        return list;
    }
    //**********添加工序计量质检记录
    @Override
    public int addPMeasureCheckService(ProcessMeasureCheck processMeasureCheck) {
        return processMeasureCheckDao.insertPMeasureCheckDao(processMeasureCheck);
    }
    //**********修改工序计量质检记录

    @Override
    public int updatePMeasureCheckService(ProcessMeasureCheck processMeasureCheck) {
        return processMeasureCheckDao.updatePMeasureCheckDao(processMeasureCheck);
    }
    //*********删除工序计量质检记录

    @Override
    public int deletePMeasureCheckService(String[] ids) {
        return processMeasureCheckDao.deletePMeasureCheckDao(ids);
    }
    //***********修改备注工序计量质检记录

    @Override
    public int updateNotePMeasureCheckService(String pMeasureCheckId, String note) {
        return processMeasureCheckDao.updateNotePMeasureCheckDao(pMeasureCheckId,note);
    }


    //-------------------------工序计数质检--------------------------------------






    /*****************人员监控接口实现*************************************/
    @Autowired
    private DepartmentDao departmentDao;
    @Override
    public  List<Department> findDepartment(){
        return departmentDao.selectDepartment();
    }
    @Override
    public Department findDepartmentById(String id){
        return departmentDao.selectDepartmentById(id);
    }
    @Override
    public int addDepartment(Department department){
        return departmentDao.insertDepartment(department);
    }
    @Override
    public int editDepartment(Department department){
        return departmentDao.updateDepartment(department);
    }
    @Override
    public int deleteDepartment(String[] ids ){
        return departmentDao.deleteDepartmentById(ids);
    }

    /*****************系统管理接口实现*************************************/


}
