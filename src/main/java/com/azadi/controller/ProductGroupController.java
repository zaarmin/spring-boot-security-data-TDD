package com.azadi.controller;


import com.azadi.mapper.ProductGroupMapper;
import com.azadi.model.dto.ProductGroupDto;
import com.azadi.service.api.ProductGroupApi;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productGroups")
public class ProductGroupController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductGroupController.class);

    @Autowired
    private ProductGroupApi productGroupApi;

    @Autowired
    ProductGroupMapper mapper;


    /**
     * Create a Product Group.
     *
     * @param productGroupDto
     */

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation(value = " create product Group")
    @ApiResponses(value= {@ApiResponse(code = 200, message = "ok"),
                          @ApiResponse(code=404 ,message = "error")})
    public void createProductGroup(@RequestBody @Validated ProductGroupDto productGroupDto) {
        LOGGER.info("POST /productGroups/add");
        productGroupApi.addProductGroup(productGroupDto);

    }

    /**
     * Update Product Group
     *
     * @param id
     * @param productGroupDto
     * @return The modified productGroupDto.
     */
    @PutMapping("/update/{id}")
    @ApiOperation(value = " Update product Group")
    public ProductGroupDto update(@PathVariable Long id, @RequestBody  @Validated ProductGroupDto productGroupDto) {
        LOGGER.info("PATCH /productGroupId/{}", id);
        return mapper.toDto(productGroupApi.updateProductGroup(id,
                productGroupDto));
    }

    /**
     * Delete a Product Group Id
     *
     * @param productGroupId
     */
    @ApiOperation(value = " Delete product Group")
    @DeleteMapping("/{productGroupId}")
    public void delete(@PathVariable(value = "productGroupId") Long productGroupId) {
        LOGGER.info("DELETE /productGroupId/{}", productGroupId);
        productGroupApi.deleteProductGroup(productGroupId);
    }



    @RequestMapping("/getAll")
    @ApiOperation(value="load All product Group")
    @ApiResponses( value={@ApiResponse(code=200 , message = "Load Success"),
                          @ApiResponse(code=404, message = " Not Found")
                 })
    public List<ProductGroupDto> findAll()
    {
        return mapper.EntitiesToDtos(productGroupApi.findAll());
    }

    @ApiOperation(value = " getByCode")
    @RequestMapping("/getByCode/{code}")
    public ProductGroupDto findByCode(@PathVariable("code") Long code)
    {
        return mapper.toDto(productGroupApi.findByCode(code)) ;
    }

   /* @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({NoSuchElementException.class , LazyInitializationException.class})
    public String return404(NoSuchElementException ex) {
        LOGGER.error("Unable to complete transaction", ex);
        return ex.getMessage();

    }*/
}
